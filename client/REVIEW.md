- mock server
  - https://mswjs.io/
- ngrok

  - 내가 실행한 프로세스를 외부에 오픈할 수 있도록 해주는 서비스
  - 예를 들어, 3000번 포트로 열려있는 프로세스를 특정 URL로 접근할 수 있도록 해줌
  - localhost:3000 -> https://random-url.ngrok.io

- 회의록

  - 날짜는 기본
  - 참석자
  - 내용 -> 형식이 있으면 좋지만, 서기가 있는 것도 아니고, 어려워
  - 일단 적고, 정리를 하는게 좋음
  - 말이되는 문장인지 살펴보는 것 보다, 관련된 문서, 코드 등 연결시켜 놓는 게 중요하다.
  - 클로바 노트 켜놓고 회의하면 좋다.

- 시멘틱 마크업 (https://html.spec.whatwg.org/multipage/)

  - HTML 네이밍하는 것과 비슷 -> 시멘틱
  - HTML 가독성이 높아짐
  - 표준을 지키면 접근성은 80% 이상 챙길 수 있게 된다.
  - 표준은 명세를 지켜서 HTML을 작성하는 방법
  - 접근성은 제약이 있는 사람도 우리 서비스를 사용할 수 있도록 하는 것
    - 우리는 단 한 사람의 사용자도 놓치지 않기 위해 접근성을 챙긴다.
    - 실제로, 항공사나 관공서 같은 경우 표준 및 접근성을 지키지 않으면 벌금을 물고 서비스가 중지되기도 한다.
  - SEO 점수에 기여함

- 의미는 유지하고 시각적으로 숨긴다.

```css
.visually-hidden {
	position: absolute;
	width: 1px;
	height: 1px;
	margin: -1px;
	border: 0;
	padding: 0;

	white-space: nowrap;
	clip-path: inset(100%);
	clip: rect(0 0 0 0);
	overflow: hidden;
}
```

- headings map
  - https://chrome.google.com/webstore/detail/headingsmap/flbjommegcjonpdmenkdiocclhjacmbi
- 브랜치 전략
  - https://tech.mfort.co.kr/blog/2022-08-05-trunk-based-development/
