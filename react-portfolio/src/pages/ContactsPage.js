import React, { useState } from 'react';
import styled from 'styled-components';
import SectionTitle from '../components/SectionTitle';

const ContactsContainer = styled.section`
  padding: 5rem 0;
  
  @media (max-width: 768px) {
    padding: 3rem 0;
  }
`;

const Subtitle = styled.h3`
  font-size: 1.8rem;
  margin-bottom: 3rem;
  color: ${props => props.theme.fourthColor};
  text-align: center;
  
  @media (max-width: 768px) {
    font-size: 1.5rem;
  }
`;

const ContactInfoContainer = styled.div`
  display: flex;
  flex-direction: column;
  gap: 2rem;
  max-width: 600px;
  margin: 0 auto;
`;

const ContactItem = styled.div`
  display: flex;
  align-items: center;
  gap: 1rem;
  padding: 1.5rem;
  border-radius: 8px;
  background-color: ${props => props.theme.secondaryColor};
  transition: transform 0.3s ease;
  cursor: pointer;
  
  &:hover {
    transform: translateY(-5px);
  }
  
  @media (max-width: 768px) {
    flex-direction: column;
    text-align: center;
    padding: 1rem;
  }
`;

const IconContainer = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  background-color: ${props => props.theme.accentColor};
  color: ${props => props.theme.thirdColor};
  font-size: 1.5rem;
`;

const ContactInfo = styled.div`
  flex: 1;
`;

const ContactType = styled.h4`
  font-size: 1.2rem;
  margin-bottom: 0.5rem;
  color: ${props => props.theme.thirdColor};
`;

const ContactValue = styled.p`
  font-size: 1rem;
  color: ${props => props.theme.fourthColor};
`;

const CopyStatus = styled.span`
  font-size: 0.8rem;
  color: ${props => props.theme.fourthColor};
  margin-left: 0.5rem;
`;

const ContactsPage = ({ strings }) => {
  const [copiedEmail, setCopiedEmail] = useState(false);
  const [copiedPhone, setCopiedPhone] = useState(false);
  
  const handleCopyEmail = () => {
    navigator.clipboard.writeText('suzdalitseva@yandex.ru');
    setCopiedEmail(true);
    setTimeout(() => setCopiedEmail(false), 2000);
  };
  
  const handleCopyPhone = () => {
    navigator.clipboard.writeText('+79933373812');
    setCopiedPhone(true);
    setTimeout(() => setCopiedPhone(false), 2000);
  };
  
  const contacts = [
    {
      type: 'Email',
      value: 'suzdalitseva@yandex.ru',
      icon: '✉️',
      handle: handleCopyEmail,
      copied: copiedEmail
    },
    {
      type: 'Phone',
      value: '+7 993 337 38 12',
      icon: '📞',
      handle: handleCopyPhone,
      copied: copiedPhone
    },
    {
      type: 'Telegram',
      value: '@zipzen',
      icon: '📱',
      url: 'https://t.me/zipzen'
    }
  ];
  
  return (
    <ContactsContainer id="contacts">
      <SectionTitle>{strings.contactsTab}</SectionTitle>
      <Subtitle>{strings.letsWork}</Subtitle>
      
      <ContactInfoContainer>
        {contacts.map((contact, index) => (
          <ContactItem 
            key={index}
            onClick={contact.handle || (() => window.open(contact.url, '_blank'))}
          >
            <IconContainer>{contact.icon}</IconContainer>
            <ContactInfo>
              <ContactType>{contact.type}</ContactType>
              <ContactValue>
                {contact.value}
                {contact.copied && <CopyStatus>{strings.copied}</CopyStatus>}
              </ContactValue>
            </ContactInfo>
          </ContactItem>
        ))}
      </ContactInfoContainer>
    </ContactsContainer>
  );
};

export default ContactsPage; 