package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.util.JsfUtil;
import br.edu.ifg.sistemacomercial.util.ReportUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Bernhard
 */
@Named
@SessionScoped
public class RelatorioBean extends JsfUtil {

    @Inject
    private EntityManager entityManager;

    private Connection connection;

    public StreamedContent relatorioCliente() {
        try {
            DefaultStreamedContent file;
            InputStream inputStream = getClass().getResourceAsStream("/br/edu/ifg/sistemacomercial/relatorios/cliente.jrxml");
            byte[] relatorio = ReportUtil.reportToPDF(inputStream, null, getConnection());
            InputStream relatorioStream = new ByteArrayInputStream(relatorio);
            String nome = "relatorio_usuario_"+new SimpleDateFormat("yyyy_MM_dd").format(new Date())+".pdf";
            file = new DefaultStreamedContent(relatorioStream, "application/pdf", nome);
            return file;
        } catch (Exception ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public StreamedContent relatorioUsuario() {
        try {
            DefaultStreamedContent file;
            InputStream inputStream = getClass().getResourceAsStream("/br/edu/ifg/sistemacomercial/relatorios/usuario.jrxml");
            byte[] relatorio = ReportUtil.reportToPDF(inputStream, null, getConnection());
            InputStream relatorioStream = new ByteArrayInputStream(relatorio);
            String nome = "relatorio_usuario_"+new SimpleDateFormat("yyyy_MM_dd").format(new Date())+".pdf";
            file = new DefaultStreamedContent(relatorioStream, "application/pdf", nome);
            return file;
        } catch (Exception ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public StreamedContent relatorioCategoria() {
        try {
            DefaultStreamedContent file;
            InputStream inputStream = getClass().getResourceAsStream("/br/edu/ifg/sistemacomercial/relatorios/categoria.jrxml");
            byte[] relatorio = ReportUtil.reportToPDF(inputStream, null, getConnection());
            InputStream relatorioStream = new ByteArrayInputStream(relatorio);
            String nome = "relatorio_categoria_"+new SimpleDateFormat("yyyy_MM_dd").format(new Date())+".pdf";
            file = new DefaultStreamedContent(relatorioStream, "application/pdf", nome);
            return file;
        } catch (Exception ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public StreamedContent relatorioProduto() {
        try {
            DefaultStreamedContent file;
            InputStream inputStream = getClass().getResourceAsStream("/br/edu/ifg/sistemacomercial/relatorios/produto.jrxml");
            byte[] relatorio = ReportUtil.reportToPDF(inputStream, null, getConnection());
            InputStream relatorioStream = new ByteArrayInputStream(relatorio);
            String nome = "relatorio_produto_"+new SimpleDateFormat("yyyy_MM_dd").format(new Date())+".pdf";
            file = new DefaultStreamedContent(relatorioStream, "application/pdf", nome);
            return file;
        } catch (Exception ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        public StreamedContent relatorioFornecedor() {
        try {
            DefaultStreamedContent file;
            InputStream inputStream = getClass().getResourceAsStream("/br/edu/ifg/sistemacomercial/relatorios/fornecedor.jrxml");
            byte[] relatorio = ReportUtil.reportToPDF(inputStream, null, getConnection());
            InputStream relatorioStream = new ByteArrayInputStream(relatorio);
            String nome = "relatorio_fornecedor_"+new SimpleDateFormat("yyyy_MM_dd").format(new Date())+".pdf";
            file = new DefaultStreamedContent(relatorioStream, "application/pdf", nome);
            return file;
        } catch (Exception ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        public StreamedContent relatorioPedido() {
        try {
            DefaultStreamedContent file;
            InputStream inputStream = getClass().getResourceAsStream("/br/edu/ifg/sistemacomercial/relatorios/pedido.jrxml");
            byte[] relatorio = ReportUtil.reportToPDF(inputStream, null, getConnection());
            InputStream relatorioStream = new ByteArrayInputStream(relatorio);
            String nome = "relatorio_pedido_"+new SimpleDateFormat("yyyy_MM_dd").format(new Date())+".pdf";
            file = new DefaultStreamedContent(relatorioStream, "application/pdf", nome);
            return file;
        } catch (Exception ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        public StreamedContent relatorioMovimento() {
        try {
            DefaultStreamedContent file;
            InputStream inputStream = getClass().getResourceAsStream("/br/edu/ifg/sistemacomercial/relatorios/movimento_estoque.jrxml");
            byte[] relatorio = ReportUtil.reportToPDF(inputStream, null, getConnection());
            InputStream relatorioStream = new ByteArrayInputStream(relatorio);
            String nome = "relatorio_movimento_estoque_"+new SimpleDateFormat("yyyy_MM_dd").format(new Date())+".pdf";
            file = new DefaultStreamedContent(relatorioStream, "application/pdf", nome);
            return file;
        } catch (Exception ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        public StreamedContent relatorioFluxoCaixa() {
        try {
            DefaultStreamedContent file;
            InputStream inputStream = getClass().getResourceAsStream("/br/edu/ifg/sistemacomercial/relatorios/fluxo_caixa.jrxml");
            byte[] relatorio = ReportUtil.reportToPDF(inputStream, null, getConnection());
            InputStream relatorioStream = new ByteArrayInputStream(relatorio);
            String nome = "relatorio_fluxo_caixa_"+new SimpleDateFormat("yyyy_MM_dd").format(new Date())+".pdf";
            file = new DefaultStreamedContent(relatorioStream, "application/pdf", nome);
            return file;
        } catch (Exception ex) {
            Logger.getLogger(RelatorioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Connection getConnection() {
        Session session = (Session) entityManager.getDelegate();
        session.doWork(
                new Work() {
                    public void execute(Connection connection) throws SQLException {
                        setConnection(connection);
                    }
                }
        );
        return this.connection;
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }
}
