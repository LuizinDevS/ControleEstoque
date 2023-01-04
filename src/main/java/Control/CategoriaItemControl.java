package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.CategoriaItemModel;

public class CategoriaItemControl 
{
	/*	C - CREATE
	  	R - READ
	  	U - UPDATE
	  	D - DELETE	*/

	//INSERT CATEGORIA DE ITEM
	public void cadastrarCategoriaItem(CategoriaItemModel categoriaItem) 
	{
		String sql = "INSERT INTO CATEGORIA_ITEM(NOME_CATEGORIA) VALUES (?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		try 
		{
			conexao = ConexaoMySQL.getConexao();
			System.out.println("Conectado ao banco de dados!");
			conexao = ConexaoMySQL.getConexao();
			
			
			pstm = (PreparedStatement) conexao.prepareStatement(sql);
			pstm.setString(2, categoriaItem.getNomeCategoriaItem());
			
			pstm.execute();
			System.out.println("Insert feito!");
	
		} catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Não foi possível estabelecer uma conexão com o banco de dados!", "ERRO: "+ e,  JOptionPane.WARNING_MESSAGE);
		}
		finally 
		{
			try 
			{
				if(pstm != null) 
				{
					pstm.close();
				}
				if(conexao != null) 
				{
					conexao.close();
				}
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
		
	//SELECT QUE VERIFICA SE O ITEM JÁ FOI CADASTRADO
	
	
	//SELECT QUE TRÁS AS CATEGORIAS DE ITENS CADASTRADAS EM ORDEM CRESCENTE
	public List<CategoriaItemModel> exibirCategoriaItem(DefaultTableModel modelo)
	{
		String sql = "SELECT * FROM CATEGORIA_ITEM ORDER BY NOME_CATEGORIA";
		List<CategoriaItemModel> categoriasItens = new ArrayList<CategoriaItemModel>(); 
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try 
		{
			conexao = ConexaoMySQL.getConexao();
			pstmt = conexao.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			//Enquanto houverem livros cadastrados
			while(rset.next()) 
			{
				//Criar nova instancia da classe livro
			    modelo.addRow(new Object[] {rset.getString("ID_CATEGORIA"), rset.getString("NOME_CATEGORIA")});
			} 
		} 
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "ERRO: "+e , "Ocorreu um erro inesperado!",  JOptionPane.ERROR_MESSAGE);
		}
		finally 
		{
			try 
			{
				if(rset != null) 
				{
					rset.close();
				}
			
				if(pstmt != null) 
				{
					pstmt.close();
				}
			
				if(conexao != null)
				{
					conexao.close();
				}
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return categoriasItens;	
	}
}
