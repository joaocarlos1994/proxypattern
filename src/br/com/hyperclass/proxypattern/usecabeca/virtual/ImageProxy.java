package br.com.hyperclass.proxypattern.usecabeca.virtual;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageProxy implements Icon {
	
	private ImageIcon imageIcon;
	private final URL imageURL;
	private Thread retrievalTread;
	private boolean retrieving = false;

	public ImageProxy(final URL imageURL) {
		super();
		this.imageURL = imageURL;
	}

	@Override
	public void paintIcon(final Component c, final Graphics g, final int x, final int y) {
		if (imageIcon != null) {
			imageIcon.paintIcon(c, g, x, y);
		} else {
			g.drawString("Loading CD cover, please wait", x+300, y+190);
			if (!retrieving) {
				retrieving = true;
				retrievalTread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							imageIcon = new ImageIcon(imageURL, "CD Cover");
							c.repaint();
						} catch (final Exception e) {
							e.printStackTrace();
						}
					}
				});
				retrievalTread.start();
			}
		}
	}

	@Override
	public int getIconWidth() {
		if (imageIcon != null) {
			return imageIcon.getIconWidth();
		} else {
			return 800;
		}
	}

	@Override
	public int getIconHeight() {
		if (imageIcon != null) {
			return imageIcon.getIconHeight();
		} else {
			return 600;
		}
	}

}
