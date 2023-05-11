// API 명세
// 아래와 같은 형식이 아니면 물어볼만하다.
// url: /api/community/:id
// method: GET, POST, PUT, DELETE
// query: {
//   postId: number; // 게시글 id
//   search: string; // 검색어
// }
// params: {
//   id: number; // 커뮤니티 id
// }
// body: {
//   title: string; // 제목
//   content: string; // 내용
//   category: string; // 카테고리
//   userId: number; // 유저 id
// }
// response: {
//   success: boolean;
//   message: string;
//   data: {
//     id: number; // 커뮤니티 id
//     title1: string; // 제목
//     user: {
//       id: number; // 유저 id
//       email: string; // 이메일
//     };
//     comments: [
//       {
//         id: number; // 댓글 id
//         content: string; // 내용
//       }
//     ];
//   };
// }

// nodejs를 다룰 줄 안다면 이런 방법을 통해 nodejs 서버를 만들어도 된다.
// 또는 React 환경에서 개발하고 있기 때문에 msw를 사용해도 된다.

const CommunityDto = (data) => {
	return {
		id: data.id,
		title: data.title1,
		user: {
			id: data.user.id,
			email: data.user.email,
		},
		comments: data.comments.map((comment) => ({
			id: comment.id,
			content: comment.content,
		})),
	};
};

// mock: 정해진 입력값에 대한 출력값을 정의해놓는다.
// mock api
const fetchCommunity = async (id) => {
	const response = await new Promise((resolve, reject) => {
		setTimeout(() => {
			if (id > 10) {
				reject({
					success: false,
					message: '커뮤니티 조회 실패',
				});
				return;
			}

			resolve({
				success: true,
				message: '커뮤니티 조회 성공',
				data: {
					id: 1,
					title: '커뮤니티 제목',
					user: {
						id: 1,
						email: '',
					},
					comments: [
						{
							id: 1,
							content: '댓글 내용',
						},
					],
				},
			});
		}, 1000);
	});

	return CommunityDto(response.data);
};

// 사용하는 쪽
const Component = () => {
	useEffect(() => {
		(async () => {
			try {
				const response = await fetchCommunity(11);
			} catch (error) {}
		})();
	}, []);

	return <div>{response.data.title}</div>;
};
