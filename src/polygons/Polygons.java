
package polygons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Collections.*;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.*;


public class Polygons extends JFrame implements ActionListener{

    int amountOfPoints = 20;
    
    JPanel knapprutan = new JPanel();
    Rutnat rutnat = new Rutnat();
    List<Point> punkter = new ArrayList();
    List<List<Point>> former = new ArrayList(new ArrayList());
    List<Polygon> allaPolys = new ArrayList();
    
    
    JButton rita = new JButton("Nya prickar!");
    JButton skapaStreck = new JButton("Streck!");
    JButton skapaPoly = new JButton("Skapa polygon");
    JButton avsluta = new JButton("Avsluta");
    JButton reset = new JButton("Reset!");
    JButton test = new JButton("test!");
    JButton createAllPolys = new JButton("Create polygon matrix");
    JButton ritaNastaPolygon = new JButton("Rita nasta polygon!");
    JButton test2 = new JButton("test2!");
    JButton taBortDuplikater = new JButton("taBortDuplikater!");
    JButton ritaStorst = new JButton("Rita storsta poly!");
    JLabel HurMangaPolys = new JLabel("Antal polygons: ");
    JButton test3 = new JButton("test3");
    JButton ritaAlla = new JButton("Rita alla");
    
    final JPanel frame = new JPanel();
    
        
    
    public Polygons(){
        rutnat.setPreferredSize(new Dimension(800,800));
        knapprutan.setPreferredSize(new Dimension(550,100));
        
        frame.setLocation(200, 200);
        frame.setSize(300, 200);
        frame.setVisible(true);
        
        rita.addActionListener(this);
        
        skapaStreck.addActionListener(this);
        
        skapaPoly.addActionListener(this);
        
        avsluta.addActionListener(this);
        
        reset.addActionListener(this);
        
        test.addActionListener(this);
        
        test2.addActionListener(this);
        
        test3.addActionListener(this);
        
        taBortDuplikater.addActionListener(this);
        
        ritaStorst.addActionListener(this);
        
        createAllPolys.addActionListener(this);
        
        ritaNastaPolygon.addActionListener(this);
        
        rutnat.addActionListener(this);
//        rutnat.addActionListener(new ActionListener(){  
//        public void actionPerformed(ActionEvent e){  
//                   System.out.println("Du klickade pa rutnatet!");
//        }  
//        });  
        
        ritaAlla.addActionListener(this);
        
        knapprutan.setBackground(Color.PINK);
        knapprutan.setVisible(true);
        knapprutan.setBorder(BorderFactory.createLineBorder(Color.black));
        knapprutan.setLayout(new FlowLayout());
        knapprutan.add(rita);
        knapprutan.add(skapaStreck);
        knapprutan.add(skapaPoly);
        knapprutan.add(reset);
//        knapprutan.add(test);
//        knapprutan.add(test2);
//        knapprutan.add(test3);
//        knapprutan.add(taBortDuplikater);
        knapprutan.add(createAllPolys);
        knapprutan.add(ritaNastaPolygon);
        knapprutan.add(ritaStorst);
        knapprutan.add(ritaAlla);
        
        add(frame);
        
        
        
                skapaStreck.setEnabled(false);
                skapaPoly.setEnabled(false);
                reset.setEnabled(false);
                test.setEnabled(false);
                test2.setEnabled(false);
                test3.setEnabled(false);
                taBortDuplikater.setEnabled(false);
                createAllPolys.setEnabled(false);
                ritaNastaPolygon.setEnabled(false);
                ritaStorst.setEnabled(false);
                ritaAlla.setEnabled(false);
        
        
        
        knapprutan.add(avsluta);
        knapprutan.add(HurMangaPolys);
        
        rutnat.setForeground(Color.lightGray);
        rutnat.setVisible(true);
        rutnat.setBorder(BorderFactory.createLineBorder(Color.black));
        
        setBackground(Color.white);
        add(rutnat);
        add(knapprutan);
        
        
        setLayout(new FlowLayout());
        
        setSize(900,900);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    
    
    
    public static void main(String[] args) {
       Polygons p = new Polygons();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            
            if(e.getSource()==rita){
                punkter.clear();
                for(int x=0; x<amountOfPoints; x++){
                    Point p = new Point(
                            (int)(Math.random()*2000), 
                            (int)(Math.random()*2000));
                    
                    
                    punkter.add(p);
                    
                }
                rutnat.gePunkter(punkter);
                List<Line> l = new ArrayList();
                rutnat.geLinjer( l);
                
                
                rita.setEnabled(true);
                skapaStreck.setEnabled(true);
                skapaPoly.setEnabled(true);
                reset.setEnabled(true);
                test.setEnabled(true);
                test2.setEnabled(true);
                test3.setEnabled(true);
                taBortDuplikater.setEnabled(true);
                createAllPolys.setEnabled(true);
                ritaNastaPolygon.setEnabled(true);
                ritaStorst.setEnabled(true);
                ritaAlla.setEnabled(true);
                avsluta.setEnabled(true);
                
                pack();
                repaint();
            }
            else if (e.getSource()==skapaPoly){
                
                List<Point> punkts = new ArrayList();
                List<Point> punkts2nd= new ArrayList();
                while(punkts.size()<3){
                    punkts.clear();
                    for(Point pp: punkter){
                        if(((int)(Math.random()*4))==1){
                            punkts.add(pp);
                        }
                    }
                }
                for(Point p: punkts){
                    punkts2nd.add(p);
                }
                
                List<Point> tl2 = new ArrayList();
                for(Point p: punkts){
                                            int tx=(int)(p.getX()/2.5);
                                            int ty=(int)(p.getY()/2.5);
                                            Point temp=new Point(tx,ty);
                                            tl2.add(temp);
                }
                punkts.clear();
                punkts=tl2;
                System.out.println("Punkterna blev: " + punkts.toString());
                System.out.println("Punkterna blev aven pa riktigt: " + punkts2nd.toString());
               
                Point[] punkts2 = punkts.toArray(new Point[punkts.size()]);
                Polygon newp = createConvexPolygonFromPoints(punkts2, punkts.size());
                punkts.clear();
                for(int x=0; x<newp.npoints; x++){
                    punkts.add(new Point((newp.xpoints[x]),(newp.ypoints[x])));
                }
                rutnat.addPolys(newp);
                boolean harPunkter=false;
                for(Point ppp: punkter){
                            Point tp = new Point((int)((ppp.x/2.5)),(int)((ppp.y/2.5)));
                            if(newp.contains(tp) && (ppp.x!=0 && ppp.y!=0) && !punkts.contains(tp)){
                                harPunkter=true;
                                System.out.println("Punkterna som lag emellan var: " + tp);
                            }
                        }
                System.out.println("Och innehaller polygonen nagon annan prick? " + harPunkter);
                rutnat.ritaSista();
                repaint();
            }
            else if (e.getSource()==skapaStreck){
                skapaStreck.setText("Remove lines.");
                if(rutnat.getLineAmount()==0){
                skapaStreck.setText("New lines!");   
                List<Line> l2 = new ArrayList();
                List<Point> tagna = new ArrayList();
                for(int x=0; x<amountOfPoints-1; x++){
                    for(int y=x+1; y<amountOfPoints; y++){
                        l2.add(new Line(punkter.get(x), punkter.get(y)));
                    }
                }
                rutnat.geLinjer(l2);
                repaint();
                }
                else{
                    rutnat.clearLines();
                    repaint();
                }
            }
            else if(e.getSource()==avsluta){
                System.exit(0); 
            }
            else if(e.getSource()==test){
                Polygon pp=new Polygon();
                
                pp.addPoint(100,100);
                pp.addPoint(100,200);
                pp.addPoint(150,150);
                pp.addPoint(200,200);
                pp.addPoint(200,100);
                rutnat.addPolys(pp);
                
                Point[] punktertemp = new Point[5];
                punktertemp[0]= new Point(100,100);
                punktertemp[1]=  new Point(100,200);
                punktertemp[2]=  new Point(150,250);
                punktertemp[3]=  new Point(200,200);
                punktertemp[4]=  new Point(200,100);
                        
                Polygon p2 = createConvexPolygonFromPoints(punktertemp,5);
                rutnat.addPolys(p2);
                rutnat.ritaAlla=true;
                System.out.println(p2.npoints);
                repaint();
                
            }
            else if (e.getSource()==test2){
                    rutnat.ritaAlla=true;
                    rutnat.ritaStorst=false;
                    repaint();
            }
            else if (e.getSource()==ritaAlla){
                if(rutnat.ritaAlla)
                    rutnat.ritaAlla=false;
                else
                    rutnat.ritaAlla=true;
                repaint();
            }
            else if (e.getSource()==taBortDuplikater){
                List<Polygon> tabortpolys=new ArrayList();
                for(int x=0; x<rutnat.polys.size(); x++){  
                    if(x%10000==0)
                        System.out.println("beraknar nummer: " + x + " av " + rutnat.polys.size());
                    for(Point pun: punkter){
                    
                        if(rutnat.getPolys().get(x).contains(pun)){
                            tabortpolys.add(rutnat.getPolys().get(x));
                            break;
                            
                        }
                    }
                }
                System.out.println("antal polys som ska tas bort:" + tabortpolys.size());
                repaint();
            }
            else if(e.getSource()==reset){
                List<Polygon> p1 = new ArrayList();
                List<Point> p2 = new ArrayList();
                List<Line> p3 = new ArrayList();
                rutnat.setPolys( p1);
                rutnat.gePunkter(p2);
                rutnat.geLinjer(p3);
                rutnat.ritaStorst=false;
                rutnat.ritaAlla=true;
                rutnat.ritaStorstNu=0;
                rutnat.storst[0]=null;
                rutnat.storst[1]=null;
                rutnat.storst[2]=null;
                rutnat.storst[3]=null;
                rutnat.storst[4]=null;
                
                skapaStreck.setEnabled(false);
                skapaPoly.setEnabled(false);
                reset.setEnabled(false);
                test.setEnabled(false);
                test2.setEnabled(false);
                test3.setEnabled(false);
                taBortDuplikater.setEnabled(false);
                createAllPolys.setEnabled(false);
                ritaNastaPolygon.setEnabled(false);
                ritaStorst.setEnabled(false);
                ritaAlla.setEnabled(false);
                
                pack();
                repaint();
            }
            
            else if (e.getSource()==rutnat){
                System.out.println("Nu forsokte du klicka pa en punkt!");
            }
            
            else if (e.getSource()==createAllPolys){
                
                Point[] punktertemp = punkter.toArray(new Point[punkter.size()]);
                Point[][] KombinationerAvPunkter2 = FaAllaKombinationer2(punktertemp);
                System.out.println("KombinationerAvPunkter: " + KombinationerAvPunkter2.length);

                    List<Polygon> polyList = new ArrayList();
                    for(int i=0; i<KombinationerAvPunkter2.length; i++){
                        
                        if(KombinationerAvPunkter2[i].length>2 ){
                            Polygon p = createConvexPolygonFromPoints(KombinationerAvPunkter2[i], KombinationerAvPunkter2[i].length);

                            boolean harPunkter= ((KombinationerAvPunkter2[i].length!=p.npoints));
                                for(Point ppp: punkter){ 
                                    if(p.contains(ppp) && !harPunkter  && (!(Arrays.asList(KombinationerAvPunkter2[i]).contains(ppp)))){
                                        harPunkter=true;
                                        break;
                                    }
                                }
                        
                        if(!harPunkter)
                            polyList.add(p);
                            }
                            if((i%10000)==0){
                                //System.out.println(i + " / " + KombinationerAvPunkter2.length);
                                System.out.println(((int)((100*i)/KombinationerAvPunkter2.length)) + "% done");
                            }
                    }
                    System.out.println("Det blev till slut " + polyList.size() + " polygons to draw!");
                    rutnat.setPolys(polyList);
                    
                repaint();
            }
            else if(e.getSource()==ritaNastaPolygon){
                rutnat.ritaNastaPolygon();
                repaint();
            }
            else if(e.getSource()==ritaStorst){
                rutnat.ritaStorst();
                repaint();
            }
        }
        catch(Exception ee){
        ee.printStackTrace();
        }
        HurMangaPolys.setText("Antal polys: " + rutnat.polys.size());
    }
    
    public static <T> List<List<T>> faAllaKombinationer(List<T> values, int size) {

    if (0 == size) {
        return Collections.singletonList(Collections.<T> emptyList());
    }

    if (values.isEmpty()) {
        return Collections.emptyList();
    }

    List<List<T>> combination = new LinkedList<List<T>>();

    T actual = values.iterator().next();

    List<T> subSet = new LinkedList<T>(values);
    subSet.remove(actual);

    List<List<T>> subSetCombination = faAllaKombinationer(subSet, size - 1);

    for (List<T> set : subSetCombination) {
        List<T> newSet = new LinkedList<T>(set);
        newSet.add(0, actual);
        combination.add(newSet);
    }

    combination.addAll(faAllaKombinationer(subSet, size));

    return combination;
}
    
    public static <Point> Point[][] FaAllaKombinationer2(Point[] a) {

    int len = a.length;
    if (len > 31)
        throw new IllegalArgumentException();

    int numCombinations = (1 << len) - 1;

    @SuppressWarnings("unchecked")
    Point[][] combinations = (Point[][]) java.lang.reflect.Array.newInstance(a.getClass(), numCombinations);

    // Start i at 1, so that we do not include the empty set in the results
    for (int i = 1; i <= numCombinations; i++) {

        @SuppressWarnings("unchecked")
        Point[] combination = (Point[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(),
                Integer.bitCount(i));

        for (int j = 0, ofs = 0; j < len; j++)
            if ((i & (1 << j)) > 0)
                combination[ofs++] = a[j];

        combinations[i - 1] = combination;
    }

    return combinations;
}
    
     // To find orientation of ordered triplet (p, q, r). 
    // The function returns following values 
    // 0 --> p, q and r are colinear 
    // 1 --> Clockwise 
    // 2 --> Counterclockwise 
    public static int orientation(Point p, Point q, Point r) 
    { 
        int val = (q.y - p.y) * (r.x - q.x) - 
                  (q.x - p.x) * (r.y - q.y); 
       
        if (val == 0) return 0;  // collinear 
        return (val > 0)? 1: 2; // clock or counterclock wise 
    } 
      
    // Prints convex hull of a set of n points. 
    public static Polygon createConvexPolygonFromPoints(Point points[], int n) 
    { 
        // There must be at least 3 points 
        if (n < 3) {
            System.out.println("nu blev det fel 422");
            return null;
        }; 
       
        // Initialize Result 
        Vector<Point> hull = new Vector<Point>(); 
       
        // Find the leftmost point 
        int l = 0; 
        for (int i = 1; i < n; i++) 
            if (points[i].x < points[l].x) 
                l = i; 
       
        // Start from leftmost point, keep moving  
        // counterclockwise until reach the start point 
        // again. This loop runs O(h) times where h is 
        // number of points in result or output. 
        int p = l, q; 
        do
        { 
            // Add current point to result 
            hull.add(points[p]); 
       
            // Search for a point 'q' such that  
            // orientation(p, x, q) is counterclockwise  
            // for all points 'x'. The idea is to keep  
            // track of last visited most counterclock- 
            // wise point in q. If any point 'i' is more  
            // counterclock-wise than q, then update q. 
            q = (p + 1) % n; 
              
            for (int i = 0; i < n; i++) 
            { 
               // If i is more counterclockwise than  
               // current q, then update q 
               if (orientation(points[p], points[i], points[q]) 
                                                   == 2) 
                   q = i; 
            } 
       
            // Now q is the most counterclockwise with 
            // respect to p. Set p as q for next iteration,  
            // so that q is added to result 'hull' 
            p = q; 
       
        } while (p != l);  // While we don't come to first  
                           // point 
       
        Polygon newp = new Polygon();
                for(Point temp: hull){
                    newp.addPoint((int)(temp.getX()), (int)(temp.getY()));
                }
                return newp;
    } 
    
    public boolean isConvex(Polygon polygon){
        
        Point a=new Point(polygon.xpoints[0],polygon.ypoints[0]);
        Point b= new Point(polygon.xpoints[1],polygon.ypoints[1]);
        boolean t=false;
        for(int i=0; i<polygon.xpoints.length-1; i++){
            
            if(!t)
                b=new Point(polygon.xpoints[i+1],polygon.ypoints[i+1]);
            else{
                b=new Point(polygon.xpoints[0],polygon.ypoints[0]);
            }
            if(getAngle(b,a)>180){
                return false;
            }
            a=b;
            if(i==polygon.xpoints.length-2 || (polygon.xpoints[i+2]==0 && polygon.ypoints[i+2]==0)){//kanske overstack har, har kanske det kollas om iterationen ovanför arrayens sista  bit ar av varde 0
                System.out.println("avbrots vid " + i );
                b=new Point(polygon.xpoints[0],polygon.ypoints[0]);
                t=true;
            }
        }
        return true;
    }
    
    public float getAngle(Point target, Point start) {
        float angle = (float) Math.toDegrees(Math.atan2(target.y - start.y, target.x - start.x));

        return angle;
    }
    
    public List kollaFormer(){
        
        List<Integer> punkter = new ArrayList();
        
        while(punkter.size()<5){
            int r = (int)(Math.random()*20);
            if(!punkter.contains(r))
                punkter.add(r);
        }
        return punkter;
    }
}

class Rutnat extends JPanel{
    
    List<Color> farger = new LinkedList();
    Random rand = new Random();
    
    boolean ritaAlla = false;
    
    Graphics g;
    
    List<Point> punkter = new ArrayList();
    List<Line> linjer = new ArrayList();
    List<Polygon> polys = new ArrayList();
    Polygon currentPolygon = null;
    int polyToDraw=-1;
    int drawnpoly=0;
    boolean ritaStorst=false;
    int ritaStorstNu=0;
    Polygon[] storst = {null, null,null,null,null};
    
    Rutnat(){
        super();
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    public List<Polygon> getPolys() {
        return polys;
    }
    public int getLineAmount(){
        return linjer.size();
    }
    public void clearLines(){
        linjer.clear();
    }
    public void removePoly(Polygon pp){
        if(polys.contains(pp))
        polys.remove(pp);
        else{
            System.out.println("obs obs nu blev nagot fel, denna polygon existerar inte men forsoks iaf bli borttagen");
        }
    }

    public void setPolyToDraw(int a){
        currentPolygon=polys.get(a);
        polyToDraw=a;
        drawnpoly=a;
    }
    public int getDrawnPoly(){
        return drawnpoly;
    }
    public void setPolys(List<Polygon> polys) {
        for(Polygon poly: polys){
            for(int i=0; i<poly.npoints; i++){
                poly.xpoints[i]=(int)(poly.xpoints[i]/2.5);
                poly.ypoints[i]=(int)(poly.ypoints[i]/2.5);
            }
        }
        this.polys = polys;
    }
    
    public void addPolys(Polygon p){
        polys.add(p);
    }
    
    public void addPolyReal(Polygon p){
        if(!polys.contains(p)){
            polys.add(p);
        }
    }
    
    public void removePolys(List<Polygon> polysToRemove){
        int counter=0;
        for(Polygon p3: polysToRemove){
                    polys.remove(p3);
                    counter++;
                    if(counter%10000==0)
                        System.out.println(counter);
                }
    }

    public void gePunkter(List<Point> punkterna){
        punkter=punkterna;
    }
    
    public void geLinjer(List<Line> linjer){
        this.linjer=linjer;
    }
    public void ritaSista(){
        polyToDraw=polys.size()-1;
        drawnpoly=polyToDraw;
    }
    public void ritaStorst(){
        ritaAlla=false;
        ritaStorst=true;
        if(storst[1]==null){
        int max0=0, max1=0, max2=0, max3=0, max4=0;
        for(Polygon p5: polys){
            double storlek=getPolygonArea(p5,p5.npoints);
            if(storlek>max0){
                storst[4]=storst[3];
                max4=max3;
                storst[3]=storst[2];
                max3=max2;
                storst[2]=storst[1];
                max2=max1;
                storst[1]=storst[0];
                max1=max0;
                storst[0]=p5;
                max0=(int)(storlek);
            }
            else if(storlek>max1){
                storst[4]=storst[3];
                max4=max3;
                storst[3]=storst[2];
                max3=max2;
                storst[2]=storst[1];
                max2=max1;
                storst[1]=p5;
                max1=(int)(storlek);
            }
            else if(storlek>max2){
                storst[4]=storst[3];
                max4=max3;
                storst[3]=storst[2];
                max3=max2;
                storst[2]=p5;
                max2=(int)(storlek);
            }
            else if(storlek>max3){
                storst[4]=storst[3];
                max4=max3;
                storst[3]=p5;
                max3=(int)(storlek);
            }
            else if(storlek>max4){
                storst[4]=p5;
                max4=(int)(storlek);
            }
            }
        
                ritaStorstNu=0;
            }
        else{
            ritaStorstNu++;
            if(ritaStorstNu==5)
                ritaStorstNu=0;
        }
        System.out.println("area av den " + (ritaStorstNu+1) + "a storsta polygonen ar: " + getPolygonArea(storst[ritaStorstNu],storst[ritaStorstNu].npoints));
    }
    public double area(Polygon a) {
        double sum = 0.0;
        int N = a.npoints-1;
        //int[] a=p.
        for (int i = 0; i < N; i++) {
            //sum = sum + (a[i].x * a[i+1].y) - (a[i].y * a[i+1].x);
                sum = sum + (a.xpoints[i] * a.ypoints[i+1]) - (a.ypoints[i] * a.xpoints[i+1]);
        }
        return Math.abs(0.5 * sum);
    }
    double getPolygonArea(Polygon polygon, int N)
        {
        int i,j;
        double area = 0;
        for (i=0;i < N;i++) 
        {
        j = (i + 1) % N;
        area += polygon.xpoints[i]* polygon.ypoints[j];
        area -= polygon.ypoints[i] * polygon.xpoints[j];
            }
        area /= 2;
        return(area < 0 ? -area : area);
    }

    public void ritaNastaPolygon(){
        ritaAlla=false;
        ritaStorst=false;
        if(polyToDraw==-1){
            polyToDraw=0;
            drawnpoly=polyToDraw;
            
        }
        else if (polyToDraw==polys.size()-1){
            drawnpoly=0;
            polyToDraw=0;
            
        }
        else{
            polyToDraw++;
            drawnpoly=polyToDraw;
        }
        
        System.out.print("polys punkter: ");
        
        System.out.println("");
    }
    
    public void ritaStrack(){
        
        for(Point P: punkter){
                    float r = rand.nextFloat();
                    float gg = rand.nextFloat();
                    float b = rand.nextFloat();
                    Color randomColor = new Color(r, gg, b);
            for(Point P2: punkter){
                if(!P.equals(P2)){
                    
                    g.setColor(randomColor);
                    g.drawLine((int)(P.getX()/2.5), (int)(P.getY()/2.5), (int)(P2.getX()/2.5), (int)(P2.getY()/2.5));
                }
            }
        }
      
    }
    
    public void paintComponent( Graphics g ){
        this.g=g;
        
        for(Point p: punkter){
            double ttx=(p.getX()/2.5);
            double tty=(p.getY()/2.5);
            int tx=(int)ttx;
            int ty=(int)tty;

            g.setColor(Color.black);
            g.fillOval(tx-(6/2), ty-(6/2), 6, 6);

        }
        for(Line l: linjer){
            g.setColor(Color.red);
                    g.drawLine((int)(l.getPointA().getX()/2.5), (int)(l.getPointA().getY()/2.5), (int)(l.getPointB().getX()/2.5), (int)(l.getPointB().getY()/2.5));
        }
        if(ritaAlla){
        for(Polygon p: polys){

            if(drawnpoly!=polys.size()){
            rand = new Random();
            float r = rand.nextFloat();
            float gg = rand.nextFloat();
            float b = rand.nextFloat();
            float alpha = (float)(0.5);
            Color randomColor = new Color(r, gg, b, alpha);
            g.setColor(randomColor);
            //g.setColor(Color.red);
            }
            
            g.fillPolygon(p);
        }
        }
        else if (ritaStorst){
            rand = new Random();
            float r = rand.nextFloat();
            float gg = rand.nextFloat();
            float b = rand.nextFloat();
            float alpha = (float)(0.5);
            Color randomColor = new Color(r, gg, b, alpha);
            g.setColor(randomColor);
            if(storst!=null)
                g.fillPolygon(storst[ritaStorstNu]);
        }
        else if(polys.size()>0){
            if(polyToDraw==-1)
                polyToDraw=0;
            
            System.out.println("Ritar polygon: " + drawnpoly + ", av " + polys.size() + " polygoner.");
            System.out.println("den har storlek: " + getPolygonArea(polys.get(polyToDraw), polys.get(polyToDraw).npoints));
            rand = new Random();
            float r = rand.nextFloat();
            float gg = rand.nextFloat();
            float b = rand.nextFloat();
            float alpha = (float)(0.5);
            Color randomColor = new Color(r, gg, b, alpha);
            g.setColor(randomColor);
            
            g.fillPolygon(polys.get(polyToDraw));
        }
    }

    void addActionListener(ActionListener actionListener) {
        System.out.println("Nu klickade du pa rutnatet!");  
    }
}

 class Line{
    
    Point pointA;
    Point pointB;

    public Line(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }
    
    
    
}
