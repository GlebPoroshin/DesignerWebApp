import { createGlobalStyle } from 'styled-components';

const GlobalStyles = createGlobalStyle`
  @font-face {
    font-family: 'Roboto';
    src: url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap');
  }
  
  body {
    font-family: 'Roboto', sans-serif;
    background-color: ${props => props.theme.mainColor};
    color: ${props => props.theme.thirdColor};
    transition: all 0.3s ease;
  }
  
  a {
    text-decoration: none;
    color: ${props => props.theme.thirdColor};
  }
  
  button {
    cursor: pointer;
    border: none;
    outline: none;
  }
`;

export default GlobalStyles; 