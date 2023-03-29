package com.lasantae.gui.views;

import java.awt.CheckboxGroup;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PasswordOptionsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PasswordOptionsPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblLength = new JLabel("Length");
		GridBagConstraints gbc_lblLength = new GridBagConstraints();
		gbc_lblLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblLength.gridx = 0;
		gbc_lblLength.gridy = 0;
		add(lblLength, gbc_lblLength);
		
		JSpinner spinnerLength = new JSpinner();
		spinnerLength.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		GridBagConstraints gbc_spinnerLength = new GridBagConstraints();
		gbc_spinnerLength.insets = new Insets(0, 0, 5, 0);
		gbc_spinnerLength.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinnerLength.gridx = 1;
		gbc_spinnerLength.gridy = 0;
		add(spinnerLength, gbc_spinnerLength);
		
		JPanel pnlCheckboxes = new JPanel();
		GridBagConstraints gbc_pnlCheckboxes = new GridBagConstraints();
		gbc_pnlCheckboxes.gridwidth = 2;
		gbc_pnlCheckboxes.insets = new Insets(0, 0, 0, 5);
		gbc_pnlCheckboxes.fill = GridBagConstraints.BOTH;
		gbc_pnlCheckboxes.gridx = 0;
		gbc_pnlCheckboxes.gridy = 1;
		add(pnlCheckboxes, gbc_pnlCheckboxes);
		
		JCheckBox chckbxUppercase = new JCheckBox("Uppercase");
		pnlCheckboxes.add(chckbxUppercase);
		
		JCheckBox chckbxLowercase = new JCheckBox("Lowercase");
		pnlCheckboxes.add(chckbxLowercase);
		
		JCheckBox chckbxSymbols = new JCheckBox("Symbols");
		pnlCheckboxes.add(chckbxSymbols);
		
		JCheckBox chckbxNumbers = new JCheckBox("Numbers");
		pnlCheckboxes.add(chckbxNumbers);

	}

}
