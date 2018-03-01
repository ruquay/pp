package poll.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.rmi.RemoteException;

import javax.swing.JButton;

import poll.model.PollList;

public class IncrementController implements ActionListener {
	private PollList polls;
	private String question;
	private String answer;

	public IncrementController (PollList polls, String q, String a) {
		this.polls = polls;
		question = q;
		answer = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		try {
			polls.increment(question, answer);
		} catch (RemoteException re) {}
	}
}
