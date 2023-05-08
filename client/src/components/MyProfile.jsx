import styled from 'styled-components';

const ProfileWrapper = styled.div`
	display: flex;
	align-items: center;
	margin-left: 20px;
	gap: 20px;
`;

const ProfileImage = styled.img`
	width: 60px;
	height: 60px;
	border-radius: 50%;
`;

const UserInfoWrapper = styled.div`
	display: flex;
	flex-direction: column;
	gap: 5px;
`;

const UserName = styled.span`
	font-size: var(--base);
	font-weight: 700;
`;

const UserEmail = styled.span`
	font-size: var(--base);
`;

export default function MyProfile() {
	return (
		<ProfileWrapper>
			<ProfileImage
				src={`${process.env.PUBLIC_URL}/assets/exprofile.png`}
				alt="Profile"
			/>
			<UserInfoWrapper>
				<UserName>username</UserName>
				<UserEmail>user@example.com</UserEmail>
			</UserInfoWrapper>
		</ProfileWrapper>
	);
}
