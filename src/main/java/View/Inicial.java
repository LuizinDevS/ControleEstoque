package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class Inicial extends JFrame 
{
	protected Dimension tamanhoTelaUsuario = Toolkit.getDefaultToolkit().getScreenSize(); //Criando um objeto dimension e buscando o tamanho da tela do usuario
	protected double larguraOriginalTela = tamanhoTelaUsuario.getWidth();//Convertendo a largura do tipo dimension para double
	protected double alturaOriginalTela = tamanhoTelaUsuario.getHeight();//Convertendo a altura do tipo dimension para double
	protected int	alturaTela = (int)alturaOriginalTela;
	protected int larguraTela = (int)larguraOriginalTela;
	protected JPanel contentPane;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Inicial frame = new Inicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//CONSTUTOR DA TELA PAI
	public Inicial() 
	{
		String nomePackageClasse = getClass().getName();
		int filtroNomeClasse  = nomePackageClasse.lastIndexOf(".");
		String nomeClasse = nomePackageClasse.substring(filtroNomeClasse);
		setTitle(nomeClasse);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1376, 768);//LEMBRAR DE MUDAR PARA:			setBounds(100, 100, larguraTela, alturaTela);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicial.class.getResource("/View/LogoClinica.png")));
		setPreferredSize(tamanhoTelaUsuario);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		//BARRA DE MENU
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		//MENU DE CADASTRO
		JMenu menuCadastro = new JMenu("Cadastro");
		menu.add(menuCadastro);
		
		JMenuItem subMenuFuncionario = new JMenuItem("Funcionário");
		menuCadastro.add(subMenuFuncionario);
		
		JMenuItem subMenuCliente = new JMenuItem("Cliente");
		menuCadastro.add(subMenuCliente);
		
		JMenuItem subMenuCategoriaProcedimento = new JMenuItem("Categoria de Procedimento");
		menuCadastro.add(subMenuCategoriaProcedimento);
		
		JMenuItem subMenuProcedimento = new JMenuItem("Procedimento");
		menuCadastro.add(subMenuProcedimento);
		
		JMenuItem subMenuCategoriaItem = new JMenuItem("Categoria Item Estoque");
		subMenuCategoriaItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CategoriaItemView categoriaItem = new CategoriaItemView();
				categoriaItem.setVisible(true);
				dispose();
			}
		});
		menuCadastro.add(subMenuCategoriaItem);
		
		JMenuItem subMenuItem = new JMenuItem("Item Estoque");
		menuCadastro.add(subMenuItem);
		
		//MENU VENDA
		JMenu menuVenda = new JMenu("Venda");
		menu.add(menuVenda);
		
		//MENU COMPRA
		JMenu menuCompra = new JMenu("Compra");
		menu.add(menuCompra);
		
		//MENU ATENDIMENTO
		JMenu menuAtendimento = new JMenu("Atendimento");
		menu.add(menuAtendimento);
		
		//MENU DE RELATORIOS
		JMenu menuRelatorio = new JMenu("Relatório");
		menu.add(menuRelatorio);
		
		JMenuItem subMenuRelatorioCompra = new JMenuItem("Relatório de Compras");
		menuRelatorio.add(subMenuRelatorioCompra);
		
		JMenuItem subMenuRelatorioVenda = new JMenuItem("Relatório de Vendas");
		menuRelatorio.add(subMenuRelatorioVenda);
		
		JMenuItem subMenuRelatorioAtendimento = new JMenuItem("Relatório de Atendimentos");
		menuRelatorio.add(subMenuRelatorioAtendimento);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(221,168,176));
		setContentPane(contentPane);
		contentPane.setLayout(new SpringLayout());
	}
	//GET DO PAINEL, AS CLASSES FILHAS HERDARÃO TUDO QUE ESTÁ NO PAINEL DA CLASSE PAI
	public JPanel getPainelPai() 
	{
		return contentPane;	
	}
}
