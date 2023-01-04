package Control;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

//Instanciar e usar em outras classes: Connection nomeConexao = ConexaoMySQL.getConnection(); 
public class ConexaoMySQL 
{
	//Strings finais para efetuar conexão com o MySQL, url/diretorio, usuario e senha de acesso ao servidor local
	private static final String url = "jdbc:mysql://localhost:3306/controle_estoque";
	private static final String usuario = "root";
	private static final String senha = "root";
	
	public static Connection getConexao() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, usuario, senha);
		
		return con;
	}
	
	public static void main(String[] args)// throws Exception 
	{
		Connection con;
		try 
		{
			con = getConexao();
			System.out.println("Conectado ao banco de dados!");
			JOptionPane.showMessageDialog(null, "Conectado ao banco de dados!");

			con.close();
		} catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Erro: "+ e, "Ocorreu um erro inseperado!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
