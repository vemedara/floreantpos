/*
 * ManagerDialog.java
 *
 * Created on September 2, 2006, 1:27 AM
 */

package com.floreantpos.ui.dialog;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.swingx.JXDatePicker;

import com.floreantpos.main.Application;
import com.floreantpos.model.TipsCashoutReport;
import com.floreantpos.model.User;
import com.floreantpos.model.dao.GratuityDAO;
import com.floreantpos.model.dao.UserDAO;
import com.floreantpos.swing.GlassPane;
import com.floreantpos.swing.ListComboBoxModel;
import com.floreantpos.ui.util.UiUtil;

/**
 *
 * @author  MShahriar
 */
public class ManagerDialog extends JDialog {
	private GlassPane glassPane;

	/** Creates new form ManagerDialog */
	public ManagerDialog() {
		super(Application.getPosWindow(), true);

		initComponents();

		setIconImage(Application.getPosWindow().getIconImage());
		setTitle(Application.getTitle() + ": Manager Functions");

		glassPane = new GlassPane();
		setGlassPane(glassPane);
	}

	public void setGlassPaneVisible(boolean b) {
		glassPane.setVisible(b);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
	private void initComponents() {
		titlePanel1 = new com.floreantpos.ui.TitlePanel();
		transparentPanel4 = new com.floreantpos.swing.TransparentPanel();
		transparentPanel2 = new com.floreantpos.swing.TransparentPanel();
		transparentPanel3 = new com.floreantpos.swing.TransparentPanel();
		btnShowTips = new com.floreantpos.swing.PosButton();
		btnDrawerPullReport = new com.floreantpos.swing.PosButton();
		btnOpenTickets = new com.floreantpos.swing.PosButton();
		btnCashDrops = new com.floreantpos.swing.PosButton();
		transparentPanel1 = new com.floreantpos.swing.TransparentPanel();
		btnFinish = new com.floreantpos.swing.PosButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		titlePanel1.setTitle(com.floreantpos.POSConstants.MANAGER_FUNCTION);
		getContentPane().add(titlePanel1, java.awt.BorderLayout.NORTH);

		transparentPanel4.setLayout(new java.awt.BorderLayout());

		transparentPanel4.setOpaque(true);
		transparentPanel2.setLayout(new java.awt.GridBagLayout());

		transparentPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
		transparentPanel3.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

		btnShowTips.setText(com.floreantpos.POSConstants.SERVER_TIPS);
		btnShowTips.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doShowServerTips(evt);
			}
		});

		transparentPanel3.add(btnShowTips);

		btnDrawerPullReport.setText(com.floreantpos.POSConstants.DRAWER_PULL);
		btnDrawerPullReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDrawerPullReportActionPerformed(evt);
			}
		});

		transparentPanel3.add(btnDrawerPullReport);

		btnOpenTickets.setText(com.floreantpos.POSConstants.OPEN_TICKETS);
		btnOpenTickets.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doShowOpenTickets();
			}
		});

		transparentPanel3.add(btnOpenTickets);

		btnCashDrops.setText(com.floreantpos.POSConstants.DRAWER_BLEED);
		btnCashDrops.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doShowCashDrops();
			}
		});

		transparentPanel3.add(btnCashDrops);

		GridBagConstraints gbc_transparentPanel3 = new GridBagConstraints();
		gbc_transparentPanel3.insets = new Insets(0, 0, 5, 0);
		gbc_transparentPanel3.gridx = 0;
		gbc_transparentPanel3.gridy = 0;
		transparentPanel2.add(transparentPanel3, gbc_transparentPanel3);

		transparentPanel4.add(transparentPanel2, java.awt.BorderLayout.CENTER);

		transparentPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

		btnFinish.setText(com.floreantpos.POSConstants.FINISH);
		btnFinish.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doCloseDialog();
			}
		});

		transparentPanel1.add(btnFinish);

		transparentPanel4.add(transparentPanel1, java.awt.BorderLayout.SOUTH);

		getContentPane().add(transparentPanel4, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void doCloseDialog() {//GEN-FIRST:event_btnFinishActionPerformed
		dispose();
	}//GEN-LAST:event_btnFinishActionPerformed

	private void doShowCashDrops() {//GEN-FIRST:event_btnCashDropsActionPerformed
		try {
			setGlassPaneVisible(true);
			CashDropDialog dialog = new CashDropDialog(ManagerDialog.this);
			dialog.initDate();
			dialog.open();
		} catch (Exception e) {
			POSMessageDialog.showError(com.floreantpos.POSConstants.ERROR_MESSAGE, e);
		} finally {
			setGlassPaneVisible(false);
		}
	}//GEN-LAST:event_btnCashDropsActionPerformed

	private void doShowOpenTickets() {//GEN-FIRST:event_btnOpenTicketsActionPerformed
		try {
			setGlassPaneVisible(true);
			OpenTicketsListDialog dialog = new OpenTicketsListDialog(ManagerDialog.this, true);
			dialog.open();
		} catch (Exception e) {
			POSMessageDialog.showError(com.floreantpos.POSConstants.ERROR_MESSAGE, e);
		} finally {
			setGlassPaneVisible(false);
		}
	}//GEN-LAST:event_btnOpenTicketsActionPerformed

	private void btnDrawerPullReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashDrawerReportActionPerformed
		doShowDrawerPullReport();
	}//GEN-LAST:event_btnCashDrawerReportActionPerformed

	private void doShowDrawerPullReport() {
		try {
			setGlassPaneVisible(true);
			DrawerPullReportDialog dialog = new DrawerPullReportDialog(ManagerDialog.this, true);
			dialog.setTitle(com.floreantpos.POSConstants.DRAWER_PULL);
			dialog.initialize();
			dialog.setSize(470, 500);
			dialog.setResizable(false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.open();
		} catch (Exception e) {
			POSMessageDialog.showError(com.floreantpos.POSConstants.ERROR_MESSAGE, e);
		} finally {
			setGlassPaneVisible(false);
		}
	}

	private void doShowServerTips(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetDrawerActionPerformed
		try {
			setGlassPaneVisible(true);

			JPanel panel = new JPanel(new MigLayout());
			List<User> users = UserDAO.getInstance().findAll();

			JXDatePicker fromDatePicker = UiUtil.getCurrentMonthStart();
			JXDatePicker toDatePicker = UiUtil.getCurrentMonthEnd();

			panel.add(new JLabel(com.floreantpos.POSConstants.SELECT_USER + ":"), "grow");
			JComboBox userCombo = new JComboBox(new ListComboBoxModel(users));
			panel.add(userCombo, "grow, wrap");
			panel.add(new JLabel(com.floreantpos.POSConstants.FROM + ":"), "grow");
			panel.add(fromDatePicker, "wrap");
			panel.add(new JLabel(com.floreantpos.POSConstants.TO_), "grow");
			panel.add(toDatePicker);

			int option = JOptionPane.showOptionDialog(ManagerDialog.this, panel, com.floreantpos.POSConstants.SELECT_CRIETERIA, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (option != JOptionPane.OK_OPTION) {
				return;
			}

			GratuityDAO gratuityDAO = new GratuityDAO();
			TipsCashoutReport report = gratuityDAO.createReport(fromDatePicker.getDate(), toDatePicker.getDate(), (User) userCombo.getSelectedItem());

			TipsCashoutReportDialog dialog = new TipsCashoutReportDialog(report, ManagerDialog.this, false);
			dialog.setSize(400, 600);
			dialog.open();
		} catch (Exception e) {
			POSMessageDialog.showError(com.floreantpos.POSConstants.ERROR_MESSAGE, e);
		} finally {
			setGlassPaneVisible(false);
		}
	}//GEN-LAST:event_btnResetDrawerActionPerformed

	public void open() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int width = 800;
		int height = 600;

		int x = (screenSize.width - 800) / 2;
		int y = (screenSize.height - 600) / 2;

		setSize(width, height);

		setLocation(x, y);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private com.floreantpos.swing.PosButton btnDrawerPullReport;
	private com.floreantpos.swing.PosButton btnCashDrops;
	private com.floreantpos.swing.PosButton btnFinish;
	private com.floreantpos.swing.PosButton btnOpenTickets;
	private com.floreantpos.swing.PosButton btnShowTips;
	private com.floreantpos.ui.TitlePanel titlePanel1;
	private com.floreantpos.swing.TransparentPanel transparentPanel1;
	private com.floreantpos.swing.TransparentPanel transparentPanel2;
	private com.floreantpos.swing.TransparentPanel transparentPanel3;
	private com.floreantpos.swing.TransparentPanel transparentPanel4;
	// End of variables declaration//GEN-END:variables

}
