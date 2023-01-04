package View;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Control.CategoriaItemControl;
import Model.CategoriaItemModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.JPanel;

public class CategoriaItemView extends Inicial
{
	private JTextField txtIdCategoria;
	private JTextField txtNomeCategoria;

	public JTextField getTxtIdCategoria() {return txtIdCategoria;}

	public void setTxtIdCategoria(JTextField txtIdCategoria) {this.txtIdCategoria = txtIdCategoria;}

	public JTextField getTxtNomeCategoria() {return txtNomeCategoria;}

	public void setTxtNomeCategoria(JTextField txtNomeCategoria) {this.txtNomeCategoria = txtNomeCategoria;}

	public CategoriaItemView() 
	{
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JLabel lblTitulo = new JLabel("CATEGORIA DE ITENS");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitulo, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblTitulo, 626, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblTitulo, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblTitulo, -566, SpringLayout.EAST, getContentPane());
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(lblTitulo);
		
		JLabel lblIdCategoria = new JLabel("ID CATEGORIA: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblIdCategoria, 79, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblIdCategoria, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblIdCategoria, 122, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblIdCategoria);
		
		JLabel lblNomeCategoriaItem = new JLabel("NOME DA CATEGORIA: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNomeCategoriaItem, 17, SpringLayout.SOUTH, lblIdCategoria);
		springLayout.putConstraint(SpringLayout.WEST, lblNomeCategoriaItem, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNomeCategoriaItem);
		
		txtIdCategoria = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtIdCategoria, -3, SpringLayout.NORTH, lblIdCategoria);
		springLayout.putConstraint(SpringLayout.WEST, txtIdCategoria, 33, SpringLayout.EAST, lblIdCategoria);
		springLayout.putConstraint(SpringLayout.SOUTH, txtIdCategoria, 22, SpringLayout.NORTH, lblIdCategoria);
		springLayout.putConstraint(SpringLayout.EAST, txtIdCategoria, -997, SpringLayout.EAST, getContentPane());
		txtIdCategoria.setColumns(10);
		getContentPane().add(txtIdCategoria);
		
		txtNomeCategoria = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtNomeCategoria, 9, SpringLayout.SOUTH, txtIdCategoria);
		springLayout.putConstraint(SpringLayout.WEST, txtNomeCategoria, 152, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, txtNomeCategoria, -995, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNomeCategoriaItem, -6, SpringLayout.WEST, txtNomeCategoria);
		txtNomeCategoria.setColumns(10);
		getContentPane().add(txtNomeCategoria);
		
		JButton btnNewButton = new JButton("LIMPAR");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 625, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 1219, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 675, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, 1350, SpringLayout.WEST, getContentPane());
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				txtNomeCategoria.setText(null);
				txtIdCategoria.setText(null);
			}
		});
		getContentPane().add(btnNewButton);
		
		DefaultTableModel modelo = (new DefaultTableModel(new Object[][] {{}}, new String[] {"ID_CATEGORIA","NOME_CATEGORIA"}));
		modelo.setNumRows(0);
		
		JPanel painel = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, txtNomeCategoria, -30, SpringLayout.NORTH, painel);
		springLayout.putConstraint(SpringLayout.NORTH, painel, 165, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, painel, -25, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNomeCategoriaItem, -30, SpringLayout.NORTH, painel);
		springLayout.putConstraint(SpringLayout.WEST, painel, 50, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, painel, -50, SpringLayout.EAST, getContentPane());
		JTable tblCategoriaItem = new JTable(modelo);		
		JScrollPane scrollPane_1 = new JScrollPane(tblCategoriaItem);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 174, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -25, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 100, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -100, SpringLayout.EAST, getContentPane());
		painel.add(scrollPane_1);
		getContentPane().add(painel);
		
		JButton btnBuscar = new JButton("BUSCAR");
		springLayout.putConstraint(SpringLayout.NORTH, btnBuscar, 625, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnBuscar, 1071, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnBuscar, 675, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnBuscar, 1202, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				modelo.setRowCount(0);
				CategoriaItemControl categoriaItemControl = new CategoriaItemControl();
				categoriaItemControl.exibirCategoriaItem(modelo);
			}
		});
		
		
		JButton btnNewButton_2 = new JButton("SALVAR");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 625, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 920, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 675, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 1051, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnNewButton_2);
		
	}
}