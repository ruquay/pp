package poll.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import poll.model.Poll;
import poll.model.PollListener;

public class LabelView extends JPanel implements PollListener {
	private Poll pm;
	private Map<String, AnswerIncrementView> myViews;
	private ActionListener controller;

	public LabelView(Poll pm, ActionListener incrController) {
		this.pm = pm;
		myViews = new HashMap<String, AnswerIncrementView>();
		controller = incrController;
		setLayout(new GridLayout(0, 1, 5, 5));
		pm.addPollModelListener(this);
		update();
	}

	public void valueChanged() {
		update();
	}

	private void update() {
		for (String answers : pm.getAnswers()) {
			AnswerIncrementView aiv = myViews.get(answers);
			if (aiv == null) {
				aiv = new AnswerIncrementView(pm, answers, controller);
				myViews.put(answers, aiv);
				add(aiv);
				revalidate();
				repaint();
			} else {
				aiv.myDataWasUpdated();
			}
		}
	}
}
