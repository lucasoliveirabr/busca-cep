package cep;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Sobre extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/about.png")));
		setBounds(500, 250, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblBuscaCep = new JLabel("BuscaCEP");
		lblBuscaCep.setBounds(187, 66, 70, 14);
		getContentPane().add(lblBuscaCep);
		
		JLabel lblAuthor = new JLabel("@Author Lucas Oliveira");
		lblAuthor.setBounds(151, 96, 150, 14);
		getContentPane().add(lblAuthor);
		
		JLabel lblWebService = new JLabel("WEB Service:");
		lblWebService.setBounds(116, 126, 80, 14);
		getContentPane().add(lblWebService);
		
		JLabel lblSite = new JLabel("republicavirtual.com.br");
		lblSite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.republicavirtual.com.br/");
			}
		});
		lblSite.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSite.setForeground(SystemColor.textHighlight);
		lblSite.setBounds(205, 126, 150, 14);
		getContentPane().add(lblSite);
		
		JButton btnGithub = new JButton("");
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/lucasoliveirabr");
			}
		});
		btnGithub.setBackground(SystemColor.control);
		btnGithub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGithub.setToolTipText("GitHub");
		btnGithub.setIcon(new ImageIcon(Sobre.class.getResource("/img/github.png")));
		btnGithub.setBorder(null);
		btnGithub.setBounds(140, 202, 48, 48);
		getContentPane().add(btnGithub);
		
		JButton btnLinkedin = new JButton("");
		btnLinkedin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://www.linkedin.com/in/lucas-oliveira-br/");
			}
		});
		btnLinkedin.setBackground(SystemColor.control);
		btnLinkedin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLinkedin.setToolTipText("LinkedIn");
		btnLinkedin.setIcon(new ImageIcon(Sobre.class.getResource("/img/linkedin.png")));
		btnLinkedin.setBorder(null);
		btnLinkedin.setBounds(240, 202, 48, 48);
		getContentPane().add(btnLinkedin);

	}
	
	private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
