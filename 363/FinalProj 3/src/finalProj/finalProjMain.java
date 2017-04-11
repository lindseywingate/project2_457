/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProj;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.util.Random;
/**
 *
 * @author Dakota Krout
 */
public class finalProjMain extends javax.swing.JFrame{

    private static CurrentAircraftPanel currentAircraftPanel;
    private static AllAircraftPanel allAircraftPanel;
    private JPanel eventLogPanel;
    private JPanel scenarioPanel;
    private JPanel radarPanel;
    private JPanel clockPanel;
    private static ArrayList<Aircraft> aircraftList;
    
    public finalProjMain()
    {
        initComponents();
        /*Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        radarPanel.setSize(new Dimension(xSize - 2*currentAircraftPanel.getWidth(),radarPanel.getHeight()));
        */
    }

    private void initComponents() {
        currentAircraftPanel = new CurrentAircraftPanel(this);
        allAircraftPanel = new AllAircraftPanel(this);
        eventLogPanel = new EventLogPanel();
        eventLogPanel.setVisible(false);
        scenarioPanel = new ScenarioPanel(this);
        radarPanel = new RadarPanel(this);
        radarPanel.setVisible(true);
        clockPanel = new ClockPanel();
        clockPanel.setVisible(false);
        //***********************************************************************************************************
        
        aircraftList = new ArrayList<Aircraft>();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //JFrame layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentAircraftPanel)
                    .addComponent(allAircraftPanel)
                    .addComponent(scenarioPanel))
                .addGap(24, 24, 24)
                //.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(radarPanel)//)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clockPanel)
                    .addComponent(eventLogPanel))
                .addGap(15, 15, 15)
            )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(currentAircraftPanel)
                            .addComponent(allAircraftPanel)
                            .addComponent(scenarioPanel))
                        .addComponent(radarPanel)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(clockPanel)
                            .addComponent(eventLogPanel))
                        
                    )
                    .addGap(15, 15, 15)
                ));
        layout.linkSize(SwingConstants.HORIZONTAL, currentAircraftPanel, allAircraftPanel, scenarioPanel, eventLogPanel, clockPanel);
    }
    private int index = -1;
    
    public void run()
    {
        //some timer thing that initiates location movement of aircraft
        //maybe implement this straight in radar panel
        int i = 1;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                //int selectedIndex = finalProjMain.getAllAircraftPanel().jList1.getSelectedIndex();                    
                index++;
                if (index > 5) {
                    index = 0;
                }
                ArrayList<Aircraft> planes = finalProjMain.getAircraftList();
                Aircraft plane = planes.get(index);
                finalProjMain.getAllAircraftPanel().updateSelected(plane.getName());
                finalProjMain.getCAP().updatePanel(plane);
            }
        };
                
        Timer time = new Timer(10000, listener);
        time.start();
        
        int random = 200 + (int)(Math.random() * ((500 - 200) + 1));
        Aircraft plane1 = new Aircraft();
        plane1.setName("UA" + random);
        random = 200 + (int)(Math.random() * ((500 - 200) + 1));
        Aircraft plane2 = new Aircraft();
        plane2.setName("AA" + random);
        random = 200 + (int)(Math.random() * ((500 - 200) + 1));
        Aircraft plane3 = new Aircraft();
        plane3.setName("FA" + random);
        random = 200 + (int)(Math.random() * ((500 - 200) + 1));
        Aircraft plane4 = new Aircraft();
        plane4.setName("AA" + random);
        random = 200 + (int)(Math.random() * ((500 - 200) + 1));
        Aircraft plane5 = new Aircraft();
        plane5.setName("JA" + random);
        random = 200 + (int)(Math.random() * ((500 - 200) + 1));
        Aircraft plane6 = new Aircraft();
        plane5.setName("AA" + random);
        this.addAircraft(plane1);
        this.addAircraft(plane2);
        this.addAircraft(plane3);
        this.addAircraft(plane4);
        this.addAircraft(plane5);
        this.addAircraft(plane6);
        finalProjMain.getCAP().updatePanel(plane1);
    }
    
    public void addAircraft(Aircraft aircraft)
    {
        if(!aircraftList.contains(aircraft))
        {
            allAircraftPanel.addPlane(aircraft);
            aircraftList.add(aircraft);
        }
    }
    
    public void updateAircraft(Aircraft aircraft)
    {
        for(int i=0; i < aircraftList.size(); i++)
        {
            Aircraft current = aircraftList.get(i);
            if(current.equals(aircraft))
            {
                aircraftList.remove(i);
                aircraftList.add(aircraft);
                break;
            }
        }
    }
    
    public void removeAircraft(Aircraft aircraft)
    {
        for(int i=0; i < aircraftList.size(); i++)
        {
            Aircraft current = aircraftList.get(i);
            if(current.equals(aircraft))
            {
                aircraftList.remove(i);
                allAircraftPanel.removePlane(aircraft);
                break;
            }
        }
    }
    
    public void propagate()
    {
        //currentAircraftPanel
        /*
        Aircraft ca = currentAircraftPanel.getAircraft();
        caIndex = getAircraftIndex(ca)
        if(caIndex != -1)
        {
            ca = aircraftList.get(caIndex);
            currentAircraftPanel.displayAircraft(ca);
        }
        else
        {
            currentAircraftPanel.clearDisplay();
        }
        */
        
        //allAircraftPanel
        /*
        allAircraftPanel.displayAircraftList(aircraftList);
        */
        
        //radarPanel
        /*
        radarPanel.updateAircraftList(aircraftList);
        */
    }
    
    private int getAircraftIndex(Aircraft aircraft)
    {
        for(int i=0; i < aircraftList.size(); i++)
        {
            Aircraft current = aircraftList.get(i);
            if(current.equals(aircraft))
            {
                return i;
            }
        }
        return -1;
    }
    
    public static ArrayList<Aircraft> getAircraftList () {
        return aircraftList;
    }
    
    public static AllAircraftPanel getAllAircraftPanel () {
        return allAircraftPanel;
    }
    
    public static CurrentAircraftPanel getCAP() {
        return currentAircraftPanel;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //init stuff to make it all display
        finalProjMain finalProjMain = new finalProjMain();
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        finalProjMain.setSize(xSize,ySize);
        finalProjMain.setVisible(true);
        
        finalProjMain.run();
        
    }
    
}
