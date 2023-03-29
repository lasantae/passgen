package com.lasantae.gui.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

public class PassgenPanel {
	private JFrame frmPassgen;
	private JPanel contentPane;
	private JPanel pnlOptions;
	private PassphraseOptionsPanel pnlPassphraseOptions;
	private PasswordOptionsPanel pnlPasswordOptions;
	
	private JRadioButton rdbtnPassword;
	private JRadioButton rdbtnPassphrase;

	private String panelIdentifierInUse; 
	private JButton btnGeneratePassword;
	private JLabel lblPassword;
	private JButton btnCopyPassword;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public PassgenPanel() {
		frmPassgen = new JFrame();
		frmPassgen.setBackground(SystemColor.menu);
		frmPassgen.setTitle("passgen");
		frmPassgen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPassgen.setSize(350, 250);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(null);

		frmPassgen.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlNorth = new JPanel();
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		GridBagLayout gbl_pnlNorth = new GridBagLayout();
		gbl_pnlNorth.columnWidths = new int[]{0, 0, 0};
		gbl_pnlNorth.rowHeights = new int[]{0, 0};
		gbl_pnlNorth.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlNorth.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlNorth.setLayout(gbl_pnlNorth);
		
		lblPassword = new JLabel("");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 0;
		pnlNorth.add(lblPassword, gbc_lblPassword);
		
		btnCopyPassword = new JButton("Copy");
		GridBagConstraints gbc_btnCopyPassword = new GridBagConstraints();
		gbc_btnCopyPassword.gridx = 1;
		gbc_btnCopyPassword.gridy = 0;
		pnlNorth.add(btnCopyPassword, gbc_btnCopyPassword);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setLayout(new BorderLayout(0, 0));
		
		btnGeneratePassword = new JButton("GENERATE");
		pnlSouth.add(btnGeneratePassword, BorderLayout.CENTER);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{0, 0};
		gbl_pnlCenter.rowHeights = new int[]{0, 0, 0};
		gbl_pnlCenter.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JPanel pnlPasswordType = new JPanel();
		GridBagConstraints gbc_pnlPasswordType = new GridBagConstraints();
		gbc_pnlPasswordType.insets = new Insets(0, 0, 5, 0);
		gbc_pnlPasswordType.fill = GridBagConstraints.BOTH;
		gbc_pnlPasswordType.gridx = 0;
		gbc_pnlPasswordType.gridy = 0;
		pnlCenter.add(pnlPasswordType, gbc_pnlPasswordType);
		
		rdbtnPassphrase = new JRadioButton("Passphrase");
		rdbtnPassphrase.setSelected(true);
		pnlPasswordType.add(rdbtnPassphrase);
		
		rdbtnPassword = new JRadioButton("Password");
		pnlPasswordType.add(rdbtnPassword);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnPassphrase);
		btnGroup.add(rdbtnPassword);
		
		pnlOptions = new JPanel();
		GridBagConstraints gbc_pnlOptions = new GridBagConstraints();
		gbc_pnlOptions.fill = GridBagConstraints.BOTH;
		gbc_pnlOptions.gridx = 0;
		gbc_pnlOptions.gridy = 1;
		pnlCenter.add(pnlOptions, gbc_pnlOptions);
		CardLayout pnlOptionsCardLayout = new CardLayout(0, 0);
		pnlOptions.setLayout(pnlOptionsCardLayout);
		
		
		pnlPassphraseOptions = new PassphraseOptionsPanel();
		pnlOptions.add(pnlPassphraseOptions, "pnlPassphraseOptions");
		pnlPasswordOptions = new PasswordOptionsPanel();
		pnlOptions.add(pnlPasswordOptions, "pnlPasswordOptions");
		
		panelIdentifierInUse = "pnlPassphraseOptions";
	}
	
	
	public JFrame getFrmPassgen() {
		return frmPassgen;
	}

	
	
	public JPanel getPnlOptions() {
		return pnlOptions;
	}


	public PassphraseOptionsPanel getPnlPassphraseOptions() {
		return pnlPassphraseOptions;
	}


	public PasswordOptionsPanel getPnlPasswordOptions() {
		return pnlPasswordOptions;
	}


	public JRadioButton getRdbtnPassword() {
		return rdbtnPassword;
	}
	
	public JRadioButton getRdbtnPassphrase() {
		return rdbtnPassphrase;
	}
	
	
	public String getPanelIdentifierInUse() {
		return panelIdentifierInUse;
	}


	public void setPanelIdentifierInUse(String panelIdentifierInUse) {
		this.panelIdentifierInUse = panelIdentifierInUse;
	}

	
	public JLabel getLblPassword() {
		return lblPassword;
	}
	
	public void setLblPassword(String p) {
		this.lblPassword.setText(p);
	}
	
	
	public void addPassphrasePanelListener(ActionListener l) {
		rdbtnPassphrase.addActionListener(l);
	}
	
	public void addPasswordPanelListener(ActionListener l) {
		rdbtnPassword.addActionListener(l);
	}
	
	public void addGenerateButtonListener(ActionListener l) {
		btnGeneratePassword.addActionListener(l);
	}
	
	public void addCopyButtonListener(ActionListener l) {
		btnCopyPassword.addActionListener(l);
	}

}
