/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JPanel;

/**
 *
 * @author P51
 */
public class Clock extends JPanel{
    private int hour, minute, second;
    
    public Clock(){
        setCurrentTime();
    }

    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int clockRadius = (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;

        g.setColor(Color.black);
        g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
        g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
        g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
        g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
        g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

        int sLength = (int) (clockRadius * 0.8);
        int xSecond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
        int ySecond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));
        g.setColor(Color.red);
        g.drawLine(xCenter, yCenter, xSecond, ySecond);

        int mLength = (int) (clockRadius * 0.65);
        int xMinute = (int) (xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60)));
        int yMinute = (int) (yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60)));
        g.setColor(Color.blue);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);

        int hLength = (int) (clockRadius * 0.5);
        int xHour = (int) (xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        int yHour = (int) (yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
        g.setColor(Color.BLACK);
        g.drawLine(xCenter, yCenter, xHour, yHour);
    }
    private void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }
    
}
