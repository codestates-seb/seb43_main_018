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
	> div {
		font-size: var(--sub-title);
		font-weight: 700;
		letter-spacing: 0.2em;
	}
`;

const LogoImage = styled.img`
	width: 60px;
	height: 60px;
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
`;

export default function Header() {
	const isMobile = useMediaQuery('(max-width: 767px)');
	const [isLogin, setIsLogin] = useState(false);
	return (
		<StyledHeader>
			<HeaderWrapper>
				<Menu>
					<MenuIcon />
				</Menu>
				<LogoWrapper>
					<LogoImage
						src={`${process.env.PUBLIC_URL}/assets/logo.png`}
						alt="로고 이미지"
					/>
					{!isMobile && <div>어디에버려</div>}
				</LogoWrapper>
				{!isLogin ? (
					<ButtonWrapper>
						<HeaderButton type="button">Sign up</HeaderButton>
						<HeaderButton type="button">Log in</HeaderButton>
					</ButtonWrapper>
				) : (
					<ButtonWrapper>
						<Profile
							src={`${process.env.PUBLIC_URL}/assets/exprofile.png`}
							alt="프로필"
						/>
						<HeaderButton type="button">Log out</HeaderButton>
					</ButtonWrapper>
				)}
			</HeaderWrapper>
		</StyledHeader>
	);
}
