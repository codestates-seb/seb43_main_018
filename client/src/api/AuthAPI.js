/* eslint-disable object-shorthand */
import axios from 'axios';

export const apiUrl = process.env.REACT_APP_API_URL;

const login = (email, password) => {
	return axios.post(
		`${apiUrl}/login`,
		{
			email,
			password,
		},
		{
			headers: {
				'Content-Type': 'application/json',
			},
		},
	);
};
export const signup = (username, email, password) => {
	return axios.post(
		`${apiUrl}/api/members`,
		{
			username,
			email,
			password,
		},
		{
			headers: {
				'Content-Type': 'application/json',
			},
		},
	);
};

export default login;
