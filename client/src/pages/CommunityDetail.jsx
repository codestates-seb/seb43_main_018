import styled from 'styled-components';
import { useLocation, useNavigate } from 'react-router-dom';
import { useState, useEffect } from 'react';
import Title from '../styles/Title';
import CommunityPost from '../components/CommunityPost';
import CommunityComment from '../components/CommunityComment';
import { Button, WarningButton } from '../styles/Buttons';
import MyProfile from '../components/MyProfile';
import Modal from '../components/Modal';
import useModal from '../hooks/useModal';
import { getPost, deleteCommunity, postCommunity } from '../api/communityAPI';
import { URL_POST } from '../routesURL';
import useInput from '../hooks/useInput';
import { URL_COMMENT } from '../urls/comments';

function CommunityDetail() {
	const navigate = useNavigate();
	const [isOpenModalP, openModalP, closeModalP] = useModal(false);
	const [isOpenModalC, openModalC, closeModalC] = useModal(false);
	const [data, setData] = useState(null);
	const location = useLocation();
	const postId = location.pathname.split('/')[2];
	const [textareaBind] = useInput();
	const [isHeart, setIsHeart] = useState(true);

	// 초기 데이터 불러오기
	useEffect(() => {
		getPost(postId).then((res) => setData(res));
		// 하트 여부 표시(setIsHeart)
	}, []);

	// 게시글 삭제 함수
	const handleConfirmP = () => {
		closeModalP();
		deleteCommunity(`/boards/${data.id}`);
		// deleteCommunity(`/read/${data.id}`); // json server
		navigate(URL_POST);
	};
	// 댓글 삭제 함수
	const handleConfirmC = () => {
		closeModalC();
		deleteCommunity(URL_COMMENT.COMMENT_DELETE(data.id));
		// deleteCommunity(`/read/${data.id}`); // json server
	};

	function postComment(value) {
		if (value !== '') {
			postCommunity(URL_COMMENT.COMMENT_CREATE, {
				b_id: data.id,
				c_contant: value,
			});
		}
	}

	function likeUpDown() {
		if (isHeart) {
			postCommunity(`boards/unlike/${data.b_id}/${data.memberId}`, null);
		} else {
			postCommunity(`boards/like/${data.b_id}/${data.memberId}`, null);
		}
		setIsHeart(!isHeart);
	}

	return (
		<DetailPage>
			<Title className="title">{data && data.b_title}</Title>
			<MyProfile />
			<CommunityPost setIsPModalOpen={openModalP} data={data} />
			<Button className="bt list" onClick={() => navigate(URL_POST)}>
				목록 보기
			</Button>
			<Button className="bt" onClick={() => likeUpDown()}>
				{data && (isHeart ? `♥ ${data.likes}` : `♡ ${data.likes}`)}
			</Button>
			<Title className="title">1개의 댓글</Title>
			<textarea placeholder="댓글을 입력하세요" {...textareaBind} />
			<WarningButton
				className="wbt bt"
				onClick={() => postComment(textareaBind.value)}
			>
				작성
			</WarningButton>
			{Array(Math.floor(Math.random() * 100))
				.fill(undefined)
				.map((el) => (
					<CommunityComment key={el} setIsCModalOpen={openModalC} />
				))}
			{isOpenModalP && (
				<Modal
					message="게시글 및 댓글이 삭제 됩니다.<br>정말 삭제하시겠습니까?"
					handleConfirm={handleConfirmP}
					handleCancel={closeModalP}
				/>
			)}
			{isOpenModalC && (
				<Modal
					message="댓글이 삭제 됩니다.<br>정말 삭제하시겠습니까?"
					handleConfirm={handleConfirmC}
					handleCancel={closeModalC}
				/>
			)}
		</DetailPage>
	);
}

const DetailPage = styled.div`
	margin-left: auto;
	margin-right: auto;
	margin-top: var(--header-hight);
	max-width: 1024px;
	padding: 50px 0px 100px 0px;
	width: 80vw;
	.title {
		margin-bottom: 20px;
	}
	.bt {
		margin: 30px 30px 30px 0px;
		font-size: var(--base);
		height: 35px;
	}

	textarea {
		font-size: var(--base);
		border-color: var(--line-color);
		width: 100%;
		height: 80px;
		background-color: var(--bg-color);
		resize: none;
		outline: none;
		border-radius: 5px;
		padding: 5px;
	}

	.wbt {
		margin: 10px 0px 20px calc(100% - 100px);
	}
	@media (max-width: 768px) {
		padding-top: 30px;
		.wbt {
			margin: 10px 0px 20px calc(100% - 60px);
		}
		.list {
			width: 80px;
		}
	}
`;

export default CommunityDetail;
