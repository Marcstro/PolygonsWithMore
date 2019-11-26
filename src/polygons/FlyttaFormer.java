
package polygons;


import java.awt.*;//the 4 imports below are for graphics reasons
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.Polygon.*;//to create the triangle
import java.util.ArrayList;//this and the one below are to 
import java.util.Collections;//change in an arraylist
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FlyttaFormer extends JFrame{
    
    public static void main(String args[]){
        new FlyttaFormer();//call this class
    }
    
    public FlyttaFormer(){
        
        int[] vilkaFormer = {1,2,3};
        //this array would decide what shapes are created
        //and their shape
        //but this program is defaulted to make 1 of each so it doesn't matter
        // 1 = square
        //2 = circle
        //3 = triangle
        //if you want to add more shapes
        //make new methods that inherit Figurer()
        //and design them new numbers
        
        JPanel rutan = new Rutan(vilkaFormer);//create the main window
        //where all things happen
        
        add(rutan);
        setVisible(true);
        setSize(400, 400);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
}

class Rutan extends JPanel {
    //this class calls on the figures in the box created in the former class
    //it also has all the necessary methods
    //to modify the figures
    
    int[] figurersFormer;//this int[] is if we wanted to create more kinds of shapes
    public ArrayList <Figurer> figurAntal = new ArrayList<Figurer>();
    //the arraylist above is a list of all shapes. So far none has been decleared
    
    
    public Rutan (int[] former) {
        
        /**for(int x=0; x<figurersFormer.length; x++){
            if(former[x]==1)
                Figurer fyrkanten = new Fyrkant(50,50);
                figurAntal.add(fyrkanten);
            else if(former[x]==2)
               Figurer cirkeln = new Cirkel(150,50);
               figurAntal.add(cirkeln);
            else if(former[x]==3)
                Figurer triangel = new Triangel(250,50);
                figurAntal.add(triangel);
        }
        the for loop above would take the int[] from the main class and convert it
        to the right number of figures of the right shapes
        this is commented
        because we create 1 of each
        **/
        
        setBackground( Color.BLACK );//my background
        setForeground( Color.BLACK );
            
        MusLyssnare ml = new MusLyssnare(this);//calling in my mouselistener
        addMouseListener (ml);
        addMouseMotionListener(ml);
        
        Figurer fyrkanten = new Fyrkant(50,50);//i make 3 shapes
        figurAntal.add(fyrkanten);//the parameters are their positions, 
        Figurer cirkeln = new Cirkel(150,50);//y=50
        figurAntal.add(cirkeln);//only x changes
        Figurer triangel = new Triangel(250,50);
        figurAntal.add(triangel);//this here adds the figures to my array of figures
        
    }
    
    
    
    public Figurer hittaFigur(int x, int y) {//find the figure-method
        for (Figurer f : figurAntal) {//loop that goes through the figures
            if (f.rymmer(x,y)) {//checks if coordinates is above a figure
                return f;//if so, returns the figure
            }
        }
        return null;
        
    }
    
    public void flyttaFigur (Figurer f, int x, int y) { //method to move figures
        f.flytta(getGraphics(), x, y);//tells the proper figure to move towards x.y
        adjustOrder(f);
        //when a figure is moved, it's placed to place 0 in the array
        //the figure at position 0 is first moved and always on top
        
        repaint();
        
    }
    
    public void adjustOrder(Figurer f){//this method changes the order of the items
        
        if (figurAntal.indexOf(f) == 1){ //if 2nd to front, go to front
            Collections.swap(figurAntal, figurAntal.indexOf(f), 0); 
        }
        else if (figurAntal.indexOf(f) ==2){ //if 3rd, go to 2nd first
            Collections.swap(figurAntal, figurAntal.indexOf(f), 1); 
            Collections.swap(figurAntal, figurAntal.indexOf(f), 0); 
        }//so that the old 2 will go to 3
    }
    
    public void paintComponent (Graphics g) {
        super.paintComponent(g);//this is my method to paint stuff
        
        //In my array of figures
        //you move the first figure if two overcross
        //but if we paint first 0, then 1 and last 2
        //the main figure will be overdrawn
        //so we reverse the collection temporarily
            Collections.reverse(figurAntal);
        for (Figurer f : figurAntal) {
            f.draw(g);
        }
            Collections.reverse(figurAntal);//now we reverse it back again
    }
    
    
    
}
    
abstract class Figurer{
    
    int x, y;
    int Sx, Sy;//abstract class
    //to show the figures what methods are necessary
    //whenever any class calls on f
    //it's going to be one of the 3 subclasses to this one
    
    abstract void draw(Graphics g);
    abstract void flytta(Graphics g, int x1, int y1);
    abstract boolean rymmer (int x1, int y1);
    public int sqr(int x){
        return (x*x);
    }
    abstract void skillnad(int x1,int y1);
    
    
}

class Fyrkant extends Figurer{
    
    int x, y;
    int size = 25;//size
    int Sx, Sy;
    public Fyrkant(int x0, int y0){//make a square at x,y
        x=x0;
        y=y0;
    }
    
    public void draw(Graphics g){//draw the square
        
        g.setColor(Color.RED);
        g.fillRect(x-size, y-size, size*2, size*2);
        
    }
    public void flytta(Graphics g, int x1, int y1){
        x=x1-Sx;
        y=y1-Sy;
    }
    public boolean rymmer (int x1, int y1) {
        if (((x-size)<x1) && ((x+size)>x1) && ((y+size)>y1) && ((y-size)<y1))
        return true;//is the square here? true for yes
        else
        return false;
    }
    public void skillnad(int x1, int y1){
     Sx=x1-x;
     Sy=y1-y;
    }
    
}
    
class Cirkel extends Figurer{
    
    int x, y;
    int radie = 25;//there's nothing in this class that the previous one didn't have
    //check commentery on Fyrkant for more info
    int Sx, Sy;
    Cirkel(int x0, int y0){
        x=x0;
        y=y0;
    }
    void draw(Graphics g){
        
        g.setColor(Color.GREEN);
        g.fillOval(x-radie, y-radie, radie*2, radie*2);
        
    }
    void flytta(Graphics g, int x1, int y1){
        x=x1-Sx;
        y=y1-Sy;
    }
    
    public boolean rymmer (int x1, int y1) {
        return sqr(x-x1)+sqr(y-y1) <= sqr(radie);
    }
    public void skillnad(int x1, int y1){
     Sx=x1-x;
     Sy=y1-y;
    }
}


class Triangel extends Figurer{
    int x, y;
    int size = 24;
    Polygon p;//we will be drawing a pologyn
    //check Fyrkant for more documentation
    int Sx, Sy;
    
    Triangel(int x0, int y0){
        x=x0;
        y=y0;
    }
    void draw(Graphics g){
        
        //we create a pologyn with 3 points
        p=new Polygon(new int[] { (x), (x-size), (x+size)}, //x points, upp, left and right
        new int[] { (y-size), (y+size), (y+size)}, 3);//y-points, upp left and right
        
        g.setColor(Color.BLUE);
        g.fillPolygon(p);
    }
    void flytta(Graphics g, int x1, int y1){
        x=x1-Sx;
        y=y1-Sy;
    }
    boolean rymmer(int x1, int y1){
       
           if (((-(y1-y+25))<=2*(x1-x)) && (((2*(x1-x))<=(y1-y+25))) && ((y1-y+25)<=(size*2)))
           return true;
           else
           return false;
           }
    
    public void skillnad(int x1, int y1){
     Sx=x1-x;
     Sy=y1-y;
    }
    
}



class MusLyssnare extends MouseAdapter implements MouseMotionListener {
    
    Rutan rutan;//the square that the figures are on
    
    Figurer markerad; //the figure we are targeting
    
        public MusLyssnare (Rutan p) {//mouse enters the picture
        rutan = p;
    }
    
    public void mousePressed (MouseEvent e) {
        
        int x = e.getX();//checks if we pressed a mouse
        int y = e.getY();

        markerad = rutan.hittaFigur(x,y);
        if(markerad!=null){
         rutan.adjustOrder(markerad);
         markerad.skillnad(x,y);   
        }
        
        

    }
    
    public void mouseClicked (MouseEvent e) {
        
        int x = e.getX();
        int y = e.getY();
        if (markerad != null) {
            rutan.flyttaFigur(markerad,x,y);
        }
    }
    
    public void mouseDragged (MouseEvent e) {
        
        int x = e.getX();//if we drag a figure, then we call flyttaFigur
        int y = e.getY();//with the new coordinates and what figure we are moving
        
        if (markerad != null) {
            rutan.flyttaFigur(markerad,x,y);
        }
    }
    
}






