package imagebrowser;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {
    
    private ActionListener[] listeners;
    private int index = 0;
    private ImagePanel imagePanel;

    public ApplicationFrame() throws HeadlessException {
        super("Image Browser");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1024, 800);
        this.setLocationRelativeTo(null);
        this.add(createImagePanel());
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }

    public void createComponents(ActionListener[] listeners) throws IOException {
        this.listeners = listeners;
        this.add(createToolbar(), BorderLayout.SOUTH);
        NextImageCommand next;
        next = (NextImageCommand)listeners[1];
        PrevImageCommand prev;
        prev = (PrevImageCommand)listeners[0];
        imagePanel.setDrag(next, prev);
        this.setVisible(true);
    }

    private JButton createButton(String title) {
        JButton button = new JButton(title);
        button.addActionListener(listeners[index++]);
        return button;
    }
    
    private JPanel createImagePanel() {
        imagePanel = new ImagePanel();
        return imagePanel;
    }
    
    private JPanel createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createButton("Prev"));
        panel.add(createButton("Next"));
        return panel;
    }
}
