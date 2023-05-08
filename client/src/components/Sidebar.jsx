import styled, { keyframes } from 'styled-components';
import { IoClose } from 'react-icons/io5';
import SidebarList from './SidebarList';
import MyProfile from './MyProfile';

const slideInLeft = keyframes`
  from {
    transform: translateX(-100%);
  }
  to {
    transform: translateX(0);
  }
`;

const slideOutLeft = keyframes`
  from {
    transform: translateX(0);
  }
  to {
    transform: translateX(-100%);
  }
`;

const SidebarWrapper = styled.div`
	display: flex;
	flex-direction: column;
	position: fixed;
	top: 80px;
	left: 0;
	bottom: 0;
	width: 300px;
	background-color: #ffffff;
	box-shadow: 2px 0px 10px rgba(0, 0, 0, 0.25);
	border-radius: 0px 10px 10px 0px;
	z-index: 10;
	animation: ${({ isOpen }) => (isOpen ? slideInLeft : slideOutLeft)} 0.5s
		ease-in-out forwards;

	@media (max-width: 768px) {
		top: 70px;
	}
`;

const CloseButton = styled.button`
	display: flex;
	flex-direction: column;
	flex: 1;
	align-self: flex-end;
	justify-content: center;
	border: none;
	background-color: transparent;
	outline: none;
	cursor: pointer;
`;

const CloseIcon = styled(IoClose)`
	font-size: var(--title);
	margin: 10px;
`;

const SidebarContent = styled.div`
	display: flex;
	flex-direction: column;
	align-items: flex-start;
	height: 100%;
`;

export default function Sidebar({ isOpen, setIsOpen }) {
	return (
		<SidebarWrapper isOpen={isOpen}>
			<CloseButton onClick={() => setIsOpen(false)}>
				<CloseIcon />
			</CloseButton>
			<SidebarContent>
				<MyProfile />
				<SidebarList />
			</SidebarContent>
		</SidebarWrapper>
	);
}
