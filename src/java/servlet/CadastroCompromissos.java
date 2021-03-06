/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "CadastroCompromissos", urlPatterns = {"/CadastroCompromissos"})
public class CadastroCompromissos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String msgRetorno = "";
        String tituloPaginaRetorno = "Erro no cadastro";
        Compromisso compromisso = new Compromisso();
        
        try {
            String textTituloCompromisso    = request.getParameter("textTituloCompromisso");
            String textTipoCompromisso      = request.getParameter("textTipoCompromisso");
            String textDataCompromisso      = request.getParameter("textDataCompromisso");
            String textHoraCompromisso      = request.getParameter("textHoraCompromisso");
            String textLocalCompromisso     = request.getParameter("textLocalCompromisso");
            Double textDuracaoCompromisso   = 
                    Double.parseDouble(request.getParameter("textDuracaoCompromisso"));
            String textObservacaoCompromisso = request.getParameter("textObservacaoCompromisso");
            
            compromisso.setTitulo(textTituloCompromisso);
            compromisso.setTipo(textTipoCompromisso);
            compromisso.setData(textDataCompromisso);
            compromisso.setHora(textHoraCompromisso);
            compromisso.setLocal(textLocalCompromisso);
            compromisso.setDuracao(textDuracaoCompromisso);
            compromisso.setObservacao(textObservacaoCompromisso);
            
            if(compromisso.select()){
                msgRetorno = "Compromisso já agendado";
            } else {

                SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyy");
                SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm");
                       
                //Validações do Formulário
                if ( textTituloCompromisso != null && !textTituloCompromisso.equals("") &&
                     textTipoCompromisso != null && !textTipoCompromisso.equals("") &&
                     textDataCompromisso != null && !textDataCompromisso.equals("") &&
                     textHoraCompromisso != null && !textHoraCompromisso.equals("") &&
                     textLocalCompromisso != null && !textLocalCompromisso.equals("") &&
                     textDuracaoCompromisso != null && !textDuracaoCompromisso.equals("") &&
                     textObservacaoCompromisso != null && !textObservacaoCompromisso.equals("")
                   ){
                    if(dataFormatada.parse(textDataCompromisso).getTime() >= System.currentTimeMillis()){
                        if(compromisso.save()){
                            msgRetorno = "Cadastro do Compromisso realizado com sucesso";
                            tituloPaginaRetorno = "Cadastro realizado com sucesso";
                        } else {
                            msgRetorno = "Falha ao cadastrar compromisso";
                        }
                    } else {
                        msgRetorno = "Você digitou uma data errada. Digite uma data futura.";
                    }
                }else{
                    msgRetorno = "Todos os campos precisam ser preenchidos.";
                }
            }
        } catch (Exception ex) {
               
            msgRetorno = ex.getMessage();
        
        } finally {
            /* TODO output your page here. You may use following sample code. */
            out.write("<!DOCTYPE html>");
            out.write("<html>");
            out.write("<head>");
            out.write("<title>" + tituloPaginaRetorno + "</title>");            
            out.write("</head>");
            out.write("<body>");
            out.write("<h1>" + msgRetorno + "</h1>");
            out.write("<a href=\"compromissos.jsp\"></a>");
            out.write("</body>");
            out.write("</html>");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

