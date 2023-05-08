import { useState } from 'react';
import GlobalStyles from './styles/index';
import Header from './components/Header';
import Sidebar from './components/Sidebar';

function App() {
	const [isOpen, setIsOpen] = useState(false); // 사이드 바 상태
	const [isLogin, setIsLogin] = useState(true);

	return (
		<>
			<GlobalStyles />
			<Header
				isLogin={isLogin}
				setIsLogin={setIsLogin}
				isOpen={isOpen}
				setIsOpen={setIsOpen}
			/>
			<Sidebar isOpen={isOpen} setIsOpen={setIsOpen} />
		</>
	);
}

export default App;
