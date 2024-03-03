# JavaMail
**Projeto destinado ao envio de e-mails através do Java com sua biblioteca nativa de interface gráfica de usuário (GUI)  e a api JavaMail**

Esse código em Java demonstra como enviar um e-mail utilizando a biblioteca JavaMail. Vou explicar o que cada parte faz:

1. Configuração do Servidor SMTP (Gmail):
   - As propriedades (props) são configuradas para se conectar ao servidor SMTP do Gmail.
   - O Gmail utiliza o protocolo SSL na porta 465.
2. Autenticação:
   - A autenticação é feita com o endereço de e-mail e senha fornecidos.
   - Substitua "seuemail@gmail.com" e "suasenha123" pelos seus próprios dados.
3. Criação da Mensagem:
   - Uma instância de MimeMessage é criada para compor o e-mail.
   - O remetente é definido como "seuemail@gmail.com".
4. Destinatários:
   - Os destinatários são definidos no array toUser.
   - Você pode adicionar vários endereços separados por vírgula.
5. Assunto e Corpo do E-mail:
   - O assunto do e-mail é definido como "Enviando email com JavaMail".
   - O corpo do e-mail é definido como "Enviei este email utilizando JavaMail com minha conta GMail!".
6. Envio do E-mail:
   - O método Transport.send(message) envia a mensagem criada.
7. Tratamento de Exceções:
   - Se ocorrer algum erro durante o envio, uma exceção MessagingException é lançada.

***Lembre-se de que, para usar esse código, você precisa ter uma conta no Gmail e permitir o acesso de aplicativos menos seguros nas configurações da sua conta***

<p align="center">
  <img src="https://raw.githubusercontent.com/jvitsilva/JavaMail/main/Images/Captura%20de%20tela%202024-03-03%20155426.png">  
</p>

<p align="center">
  <img src="https://github.com/jvitsilva/JavaMail/blob/main/Images/Captura%20de%20tela%202024-03-03%20155439.png?raw=true">  
</p>
