import React, { useState, useRef, useEffect } from 'react';
import styled, { ThemeProvider } from 'styled-components';
import { lightTheme, darkTheme } from './theme/colors';
import { engStrings, rusStrings } from './theme/strings';
import GlobalStyles from './theme/GlobalStyles';

import Header from './components/Header';
import HomePage from './pages/HomePage';
import AboutPage from './pages/AboutPage';
import SkillsPage from './pages/SkillsPage';
import ProjectsPage from './pages/ProjectsPage';
import ContactsPage from './pages/ContactsPage';

const Container = styled.div`
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
`;

const ScrollToTopButton = styled.button`
  position: fixed;
  bottom: 30px;
  right: 30px;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  background-color: ${props => props.theme.thirdColor};
  color: ${props => props.theme.mainColor};
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 1.5rem;
  cursor: pointer;
  border: none;
  outline: none;
  opacity: ${props => props.visible ? '1' : '0'};
  visibility: ${props => props.visible ? 'visible' : 'hidden'};
  transition: opacity 0.3s, visibility 0.3s;
  
  &:hover {
    background-color: ${props => props.theme.fourthColor};
  }
`;

const App = () => {
  const [isEnglish, setIsEnglish] = useState(true);
  const [isBlackTheme, setIsBlackTheme] = useState(false);
  const [currentPage, setCurrentPage] = useState(0);
  const [showScrollButton, setShowScrollButton] = useState(false);
  
  const strings = isEnglish ? engStrings : rusStrings;
  const theme = isBlackTheme ? darkTheme : lightTheme;
  
  const homeRef = useRef(null);
  const aboutRef = useRef(null);
  const skillsRef = useRef(null);
  const projectsRef = useRef(null);
  const contactsRef = useRef(null);
  
  const sectionRefs = [homeRef, aboutRef, skillsRef, projectsRef, contactsRef];
  
  const handleScroll = () => {
    if (window.pageYOffset > 300) {
      setShowScrollButton(true);
    } else {
      setShowScrollButton(false);
    }
  };
  
  useEffect(() => {
    window.addEventListener('scroll', handleScroll);
    return () => window.removeEventListener('scroll', handleScroll);
  }, []);
  
  const scrollToTop = () => {
    window.scrollTo({
      top: 0,
      behavior: 'smooth'
    });
  };
  
  const handlePageChange = (pageIndex) => {
    sectionRefs[pageIndex].current.scrollIntoView({ behavior: 'smooth' });
    setCurrentPage(pageIndex);
  };
  
  const contentsNamesList = [
    strings.homeTab,
    strings.aboutTab,
    strings.skillsTab,
    strings.projectsTab,
    strings.contactsTab
  ];
  
  // Mock URI handler for compatibility with original code
  const uriHandler = {
    openUri: (uri) => {
      window.open(uri, '_blank');
    }
  };
  
  return (
    <ThemeProvider theme={theme}>
      <GlobalStyles />
      <Container>
        <Header 
          isEnglish={isEnglish}
          onLanguageChange={() => setIsEnglish(!isEnglish)}
          contentsNamesList={contentsNamesList}
          onPageChange={handlePageChange}
          isBlackTheme={isBlackTheme}
          onThemeChange={() => setIsBlackTheme(!isBlackTheme)}
          currentPage={currentPage}
        />
        
        <div ref={homeRef}>
          <HomePage strings={strings} uriHandler={uriHandler} />
        </div>
        
        <div ref={aboutRef}>
          <AboutPage strings={strings} uriHandler={uriHandler} />
        </div>
        
        <div ref={skillsRef}>
          <SkillsPage strings={strings} />
        </div>
        
        <div ref={projectsRef}>
          <ProjectsPage strings={strings} />
        </div>
        
        <div ref={contactsRef}>
          <ContactsPage strings={strings} />
        </div>
      </Container>
      
      <ScrollToTopButton 
        visible={showScrollButton}
        onClick={scrollToTop}
      >
        ↑
      </ScrollToTopButton>
    </ThemeProvider>
  );
};

export default App; 