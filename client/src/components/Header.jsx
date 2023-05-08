import styled from 'styled-components';
import { FiMenu } from 'react-icons/fi';
import { useState } from 'react';
import useMediaQuery from '../hooks/useMediaQuery';
import { HeaderButton } from '../styles/Buttons';

const StyledHeader = styled.header`
	display: flex;
	align-items: center;
	justify-content: center;
	height: 80px;
	width: 100%;
	padding: 0 20px;
	background-color: var(--bg-color);
	box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.25);
	position: fixed;
	top: 0;
	left: 0;
	z-index: 10;

	@media (max-width: 768px) {
		height: 70px;
	}
`;

const HeaderWrapper = styled.div`
	display: flex;
	align-items: center;
	max-width: 100%;
	width: 100%;
	height: 100%;
`;

const Menu = styled.button`
	display: flex;
	flex: 1;
	justify-content: flex-start;
	border: none;
	background-color: transparent;
	outline: none;
	cursor: pointer;
`;

const MenuIcon = styled(FiMenu)`
	font-size: var(--title);
`;

const LogoWrapper = styled.div`
	display: flex;
	flex: 2;
	text-align: center;
	align-items: center;
	justify-content: center;
	gap: 10px;
`;

const LogoImage = styled.img`
	width: 60px;
	height: 60px;
`;

const LogoText = styled.div`
	font-size: var(--sub-title);
	font-weight: 700;
	letter-spacing: 0.2em;
`;

const ButtonWrapper = styled.div`
	flex: 1;
	display: flex;
	justify-content: flex-end;
	> * {
		margin-left: 10px;
	}
`;

const Profile = styled.img`
	width: 50px;
	height: 50px;
	border-radius: 50px;

	@media (max-width: 768px) {
		width: 40px;
		height: 40px;
	}
`;

export default function Header({ isLogin, setIsLogin, isOpen, setIsOpen }) {
	const isMobile = useMediaQuery('(max-width: 768px)');

	const handleLogout = () => {
		setIsLogin(false);
		// 지도 페이지로 네비게이트
	};
	const toggleSideBar = () => {
		setIsOpen(!isOpen);
	};
	return (
		<StyledHeader>
			<HeaderWrapper>
				<Menu>
					<MenuIcon onClick={toggleSideBar} />
				</Menu>
				<LogoWrapper>
					<LogoImage
						src={`${process.env.PUBLIC_URL}/assets/logo.png`}
						alt="로고 이미지"
					/>
					{!isMobile && <LogoText>어디에버려</LogoText>}
				</LogoWrapper>
				{!isLogin ? (
					<ButtonWrapper>
						<HeaderButton
							type="button"
							// 회원가입 페이지로 링크
						>
							Sign up
						</HeaderButton>
						<HeaderButton
							type="button"
							// 로그인 페이지로 링크
						>
							Log in
						</HeaderButton>
					</ButtonWrapper>
				) : (
					<ButtonWrapper>
						<Profile
							// 마이페이지로 링크
							src={`${process.env.PUBLIC_URL}/assets/exprofile.png`}
							alt="프로필"
						/>
						<HeaderButton type="button" onClick={handleLogout}>
							Log out
						</HeaderButton>
					</ButtonWrapper>
				)}
			</HeaderWrapper>
		</StyledHeader>
	);
}
