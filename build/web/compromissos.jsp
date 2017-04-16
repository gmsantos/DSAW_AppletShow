<%-- 
    Document   : compromissos
    Created on : 15/04/2017, 10:36:26
    Author     : Daniel Constantino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agendamento de Compromissos</title>
    </head>
    <body>
        <h1>Agendamento de Compromissos</h1>
        <form action="AgendarCompromisso" id="formAgendamento" method="POST">
            
            <label id="labelTituloCompromisso">Título: </label>
            <input name="textTituloCompromisso" size="45"/><br/><br/>
            
            <label id="labelTipoCompromisso">Título: </label>
            <input name="textTipoCompromisso" size="45"/><br/><br/>
            
            <label id="labelDataCompromisso">Data: </label>
            <input name="textDataCompromisso" size="11"/><br/><br/>
            
            <label id="labelHoraCompromisso">Hora: </label>
            <input name="textHoraCompromisso" size="5"/><br/><br/>
            
            <label id="labelLocalCompromisso">Local: </label>
            <input name="textLocalCompromisso" size="45"/><br/><br/>
            
            <label id="labelDuracaoCompromisso">Duração: </label>
            <input name="textDuracaoCompromisso" size="13"/><br/><br/>
            
            <label id="labelObservacaoCompromisso">Observação: </label>
            <input name="textObservacaoCompromisso" size="200"/><br/><br/>
               
            <input id="botaoCadastrar" type="submit" value="Cadastrar">
            
        </form>
    </body>
</html>
