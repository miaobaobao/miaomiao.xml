import java.io.File;
import java.sql.Timestamp;
import java.util.Iterator;  
import java.util.List;  
  
import org.dom4j.Attribute;  
import org.dom4j.Document;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;  

/*
 * ����XML������ͨ����ȡDocument����Ȼ�������ȡ�����ڵ��Լ����ԵȲ���
 */
  
public class TestXml {  
	
   public  void test() throws Exception{       
        SAXReader reader = new SAXReader();  //����SAXReader����    
        Document document = reader.read(new File("Library.xml"));  //��ȡ�ļ� ת����Document ���Ҵ���file�ļ�         
        Element root = document.getRootElement();   //��ȡ���ڵ�Ԫ�ض���          
        this.listNodes(root);//�Ӹ�������  
    }  
      
    /*
     * �����ӽڵ�
     */
    public void listNodes(Element node){  
        System.out.println("��ǰ�ڵ�����ƣ�" + node.getName());  
        //���Ȼ�ȡ��ǰ�ڵ���������Խڵ�  
        List<Attribute> list = node.attributes();  
        //�������Խڵ�  
        for(Attribute attribute : list){  
            System.out.println("����"+attribute.getName() +":" + attribute.getValue());  
        }  
        //�����ǰ�ڵ����ݲ�Ϊ�գ������  
        if(!(node.getTextTrim().equals(""))){  
             System.out.println( node.getName() + "��" + node.getText());    
        }  
        //ͬʱ������ǰ�ڵ�����������ӽڵ�  
        //ʹ�õݹ�  
        Iterator<Element> iterator = node.elementIterator();  
        while(iterator.hasNext()){  
            Element e = iterator.next();  
            this.listNodes(e);  
        }  
    }
 
	
}  
