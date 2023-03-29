package com.lasantae.gui.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JSpinner;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.SpinnerNumberModel;

public class PassphraseOptionsPanel extends JPanel {
	private final JLabel lblWordAmount = new JLabel("Words");
	private final JSpinner spinnerWordAmount = new JSpinner();
	private JTextField textFieldDelimiter;
	private JRadioButton rdbtnLowercase;
	private JRadioButton rdbtnTitleCase;
	private JRadioButton rdbtnUppercase;

	public PassphraseOptionsPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblWordAmount = new GridBagConstraints();
		gbc_lblWordAmount.insets = new Insets(0, 0, 5, 5);
		gbc_lblWordAmount.gridx = 0;
		gbc_lblWordAmount.gridy = 0;
		lblWordAmount.setToolTipText("");
		add(lblWordAmount, gbc_lblWordAmount);
		lblWordAmount.setLabelFor(spinnerWordAmount);
		GridBagConstraints gbc_spinnerWordAmount = new GridBagConstraints();
		gbc_spinnerWordAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerWordAmount.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerWordAmount.gridx = 1;
		gbc_spinnerWordAmount.gridy = 0;
		spinnerWordAmount.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		add(spinnerWordAmount, gbc_spinnerWordAmount);
		
		JLabel lblDelimiter = new JLabel("Delimiter");
		GridBagConstraints gbc_lblDelimiter = new GridBagConstraints();
		gbc_lblDelimiter.insets = new Insets(0, 0, 5, 5);
		gbc_lblDelimiter.gridx = 0;
		gbc_lblDelimiter.gridy = 1;
		add(lblDelimiter, gbc_lblDelimiter);
		
		textFieldDelimiter = new JTextField();
		lblDelimiter.setLabelFor(textFieldDelimiter);
		GridBagConstraints gbc_textFieldDelimiter = new GridBagConstraints();
		gbc_textFieldDelimiter.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDelimiter.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDelimiter.gridx = 1;
		gbc_textFieldDelimiter.gridy = 1;
		add(textFieldDelimiter, gbc_textFieldDelimiter);
		textFieldDelimiter.setColumns(10);
		
		JPanel panelRadioButtons = new JPanel();
		GridBagConstraints gbc_panelRadioButtons = new GridBagConstraints();
		gbc_panelRadioButtons.gridwidth = 2;
		gbc_panelRadioButtons.fill = GridBagConstraints.BOTH;
		gbc_panelRadioButtons.gridx = 0;
		gbc_panelRadioButtons.gridy = 2;
		add(panelRadioButtons, gbc_panelRadioButtons);
		
		rdbtnTitleCase = new JRadioButton("Title Case");
		rdbtnTitleCase.setSelected(true);
		panelRadioButtons.add(rdbtnTitleCase);
		
		rdbtnLowercase = new JRadioButton("lowercase");
		panelRadioButtons.add(rdbtnLowercase);
		
		rdbtnUppercase = new JRadioButton("UPPERCASE");
		panelRadioButtons.add(rdbtnUppercase);
		
		ButtonGroup bntGroupCases = new ButtonGroup();
		bntGroupCases.add(rdbtnTitleCase);
		bntGroupCases.add(rdbtnLowercase);
		bntGroupCases.add(rdbtnUppercase);

	}

	
	public JSpinner getSpinnerWordAmount() {
		return spinnerWordAmount;
	}
	public JTextField getTextFieldDelimiter() {
		return textFieldDelimiter;
	}
	public JRadioButton getRdbtnLowercase() {
		return rdbtnLowercase;
	}
	public JRadioButton getRdbtnTitleCase() {
		return rdbtnTitleCase;
	}
	public JRadioButton getRdbtnUppercase() {
		return rdbtnUppercase;
	}
}
