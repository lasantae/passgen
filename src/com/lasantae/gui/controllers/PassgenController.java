package com.lasantae.gui.controllers;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.lasantae.gui.views.PassgenPanel;
import com.lasantae.gui.views.PassphraseOptionsPanel;
import com.lasantae.gui.views.PasswordOptionsPanel;

import password.generator.data.Wordlist;
import password.generator.generators.PassphraseGenerator;
import password.generator.generators.PassphraseGenerator.Cases;
import password.generator.generators.PasswordGenerator;

public class PassgenController {
	private PassgenPanel view;
	
	private PassphraseGenerator passphraseGenerator;
	private final Wordlist WORDLIST = Wordlist.instantiate(new File("./resources/wordlists/eff_long_wordlist.txt"));
	
	private PasswordGenerator passwordGenerator;
	
	
	public PassgenController(PassgenPanel view) {
		super();
		this.view = view;
		this.passphraseGenerator = new PassphraseGenerator();
		this.passwordGenerator = new PasswordGenerator();
		
		view.addCopyButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String password = view.getLblPassword().getText();
				
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(new StringSelection(password), null);
			}
		});
		
		view.addPassphrasePanelListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout) view.getPnlOptions().getLayout();
				JPanel panel = view.getPnlOptions();
				
				String PANEL_IDENTIFIER_IN_USE = "pnlPassphraseOptions";
				layout.show(panel, PANEL_IDENTIFIER_IN_USE);
				view.setPanelIdentifierInUse(PANEL_IDENTIFIER_IN_USE);
			}
		});
		
		view.addPasswordPanelListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout) view.getPnlOptions().getLayout();
				JPanel panel = view.getPnlOptions();
				
				String PANEL_IDENTIFIER_IN_USE = "pnlPasswordOptions";
				layout.show(panel, PANEL_IDENTIFIER_IN_USE);
				view.setPanelIdentifierInUse(PANEL_IDENTIFIER_IN_USE);
			}
		});
		
		view.addGenerateButtonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String PANEL_IDENTIFIER_IN_USE = view.getPanelIdentifierInUse();
				
				switch (PANEL_IDENTIFIER_IN_USE) {
					case "pnlPassphraseOptions" -> {
						PassphraseOptionsPanel panel = view.getPnlPassphraseOptions();
						int words = (int) panel.getSpinnerWordAmount().getValue(); 
						String delimiter = panel.getTextFieldDelimiter().getText();
					
						PassphraseGenerator.Cases c = Cases.TITLE_CASE;	
						if (panel.getRdbtnLowercase().isSelected()) c = Cases.LOWERCASE;
						else if (panel.getRdbtnUppercase().isSelected()) c = Cases.UPPERCASE;
						
						String passphrase = PassphraseGenerator.getPassphrase(WORDLIST, words, delimiter, c);
						view.setLblPassword(passphrase);
						
					}
					case "pnlPasswordOptions" -> {
					
						PasswordOptionsPanel panel = view.getPnlPasswordOptions();
						
						int length = (int) panel.getSpinnerLength().getValue();
						boolean includeUppercase = panel.getChckbxUppercase().isSelected();
						boolean includeLowercase = panel.getChckbxLowercase().isSelected();
						boolean includeSymbols = panel.getChckbxSymbols().isSelected();
						boolean includeNumbers = panel.getChckbxNumbers().isSelected();
						
						// check if any of the checkboxes is selected before generating a password. 
						if (!(includeUppercase || includeLowercase || includeSymbols || includeNumbers)) {
							JOptionPane.showMessageDialog(view.getFrmPassgen(), "Please select one or more options.");
							break;
						}
						
						String password = PasswordGenerator.getPassword(length, includeUppercase, includeLowercase, includeSymbols, includeNumbers);
						view.setLblPassword(password);
					}
				}
				
			}
		});
	}
	
	public void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					view.getFrmPassgen().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
