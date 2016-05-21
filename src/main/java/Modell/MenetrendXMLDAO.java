/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modell;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Rácz Dénes
 */
public class MenetrendXMLDAO {
    
    
    public List<Menetrend> getBuszMegallo(int buszszam,String megallo) throws ParserConfigurationException, SAXException, IOException{
        List<Menetrend> ll = new ArrayList<>();
        int keses = 0;
        ll = getBusz(buszszam);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = factory.newDocumentBuilder();
        Document doc = dbuilder.parse(new File("Megallok.xml"));
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("buszszam");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            if (Integer.parseInt(eElement.getAttribute("szam")) == (buszszam)) {
                NodeList nListTmp = eElement.getElementsByTagName("megallo");
                for(int j=0;j<nListTmp.getLength();j++){
                    Node nNodeTmp = nListTmp.item(j);
                    Element eElementTmp = (Element) nNodeTmp;
                    if (eElementTmp.getTextContent().trim().equals(megallo)){
                        keses = Integer.parseInt(eElementTmp.getAttribute("menetido"));
                        break;
                    }
                }
            }
          }
        //System.out.println(keses);
        List<Menetrend> re = new ArrayList<>();
            String at1 = "";
            String at2 = "";
            String at3 = "";
            String at4 = "";
        for(Menetrend e : ll){
            String[] tmp1 = e.getMunkanap().split(" ");
            String[] tmp2 = e.getTanszunet().split(" ");
            String[] tmp3 = e.getSzabadnap().split(" ");
            String[] tmp4 = e.getMunkaszunet().split(" ");
            String tp = "";
            String tmp_o1 = "";
            for(int i =0;i<tmp1.length;i++){
                if(i==0&&at1!="") {tmp_o1=at1;at1="";}
                
                int vmi; 
                vmi = Integer.parseInt(tmp1[i])+keses;
                if (vmi>59){
                    at1=at1+" "+(vmi-60);
                }else{
                    tmp_o1=tmp_o1+" "+vmi;
                }
            }
            String tmp_o2 = "";
            for(int i = 0;i<tmp2.length;i++){
                if(i==0&&at2!="") {tmp_o2=at2;at2="";}
                int vmi; 
                vmi = Integer.parseInt(tmp2[i])+keses;
                if (vmi>59){
                    at2=at2+" "+(vmi-60);
                }else{
                    tmp_o2=tmp_o2+" "+vmi;
                }
            }
            String tmp_o3 = "";
            for(int i =0;i<tmp3.length;i++){
                if(i==0&&at3!="") {tmp_o3=at3;at3="";}
                int vmi; 
                vmi = Integer.parseInt(tmp3[i])+keses;
                if (vmi>59){
                    at3=at3+" "+(vmi-60);
                }else{
                    tmp_o3=tmp_o3+" "+vmi;
                }
            }
            String tmp_o4 = "";
            for(int i =0;i<tmp4.length;i++){
                if(i==0&&at4!="") {tmp_o4=at4;at4="";}
                int vmi; 
                vmi = Integer.parseInt(tmp4[i])+keses;
                //System.out.println(vmi);
                if (vmi>59){
                    at4=at4+" "+(vmi-60);
                }else{
                    tmp_o4=tmp_o4+" "+vmi;
                }
                
            }
            re.add(new Menetrend(e.getOra(),tmp_o1.trim(),tmp_o2.trim(),tmp_o3.trim(),tmp_o4.trim()));
        }
        return re;
    }
    
    public List<Integer> getBuszok(String megallo) throws SAXException, ParserConfigurationException, IOException{
        List<Integer> ll = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = factory.newDocumentBuilder();
        Document doc = dbuilder.parse(new File("Megallok.xml"));
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("buszszam");
        
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            
                NodeList nListTmp = eElement.getElementsByTagName("megallo");
                //System.out.println(nListTmp.item(0).getTextContent());
                //System.out.println(nListTmp.getLength());
                for (int j = 0; j< nListTmp.getLength();j++){
                    Node n = nListTmp.item(j);
                    Element e = (Element) n;
                    //System.out.println(e.getElementsByTagName("Munkanap").item(0).getTextContent());
                    if(e.getTextContent().trim().equals(megallo)){
                        //System.out.println("be");
                        if(!ll.contains(Integer.parseInt(eElement.getAttribute("szam"))))
                            ll.add(Integer.parseInt(eElement.getAttribute("szam")));
                    }
                }
            
        } 
        return ll;
    }
    
    public List<String> MegallokStart() throws ParserConfigurationException, SAXException, IOException{
        List<String> ll = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = factory.newDocumentBuilder();
        Document doc = dbuilder.parse(new File("Megallok.xml"));
        
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("buszszam");
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            NodeList nListTmp = eElement.getElementsByTagName("megallo");
            for (int j = 0; j < nListTmp.getLength();j++){
                Node n = nListTmp.item(j);
                Element e = (Element) n;
                if (!ll.contains(e.getTextContent().trim())){
                    ll.add(e.getTextContent().trim());
                }
            }
        }
        
        return ll;
    }
    public List<Integer> getStart() throws ParserConfigurationException, SAXException, IOException{
        List<Integer> ll = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = factory.newDocumentBuilder();
        Document doc = dbuilder.parse(new File("Menetrend.xml"));
        //System.out.println("baaaaaaaaaaaaaaaaaaaaaaazmeeeeeeeeeeeeg");

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("buszszam");
        
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            ll.add(Integer.parseInt(eElement.getAttribute("szam")));
            
        }
        
        return ll;
    }
    public List<Megallo> getMegallo(int buszszam) throws ParserConfigurationException, SAXException, IOException{
        List<Megallo> ll = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = factory.newDocumentBuilder();
        Document doc = dbuilder.parse(new File("Megallok.xml"));
        //System.out.println("baaaaaaaaaaaaaaaaaaaaaaazmeeeeeeeeeeeeg");

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("buszszam");
        //System.out.println(nList.item(0).getAttributes().item(0));
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            if (Integer.parseInt(eElement.getAttribute("szam")) == (buszszam)) {
                NodeList nListTmp = eElement.getElementsByTagName("megallo");
                //System.out.println(nListTmp.item(0).getTextContent());
                //System.out.println(nListTmp.getLength());
                for (int j = 0; j< nListTmp.getLength();j++){
                    Node n = nListTmp.item(j);
                    Element e = (Element) n;
                    //System.out.println(e.getElementsByTagName("Munkanap").item(0).getTextContent());
                    ll.add(new Megallo(Integer.parseInt(e.getAttribute("menetido")),e.getTextContent().trim()));
                }
            }
        }
        return ll;
    }
    
    public List<Menetrend> getBusz(int buszszam) throws ParserConfigurationException, SAXException, IOException {
        List<Menetrend> ll = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder = factory.newDocumentBuilder();
        Document doc = dbuilder.parse(new File("Menetrend.xml"));
        //System.out.println("baaaaaaaaaaaaaaaaaaaaaaazmeeeeeeeeeeeeg");

        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("buszszam");
        //System.out.println(nList.item(0).getAttributes().item(0));
        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            if (Integer.parseInt(eElement.getAttribute("szam")) == (buszszam)) {
                NodeList nListTmp = eElement.getElementsByTagName("ora");
                //System.out.println(nListTmp.item(0).getTextContent());
                //System.out.println(nListTmp.getLength());
                for (int j = 0; j< nListTmp.getLength();j++){
                    Node n = nListTmp.item(j);
                    Element e = (Element) n;
                    //System.out.println(e.getElementsByTagName("Munkanap").item(0).getTextContent());
                    ll.add(new Menetrend(Integer.parseInt(e.getAttribute("ora")),e.getElementsByTagName("Munkanap").item(0).getTextContent(),e.getElementsByTagName("Tanszunet").item(0).getTextContent()
                            ,e.getElementsByTagName("Szabadnap").item(0).getTextContent(),e.getElementsByTagName("Munkaszunet").item(0).getTextContent()));
                }
            }
        }
        return ll;
    }
}
