import java.io.File;
import java.sql.Timestamp;
import java.util.Iterator;  
import java.util.List;  
  
import org.dom4j.Attribute;  
import org.dom4j.Document;  
import org.dom4j.Element;  
import org.dom4j.io.SAXReader;  

/*
 * 解析XML过程是通过获取Document对象，然后继续获取各个节点以及属性等操作
 */
  
public class TestXml {  
	
   public  void test() throws Exception{       
        SAXReader reader = new SAXReader();  //创建SAXReader对象    
        Document document = reader.read(new File("Library.xml"));  //读取文件 转换成Document 并且创建file文件         
        Element root = document.getRootElement();   //获取根节点元素对象          
        this.listNodes(root);//从跟结点遍历  
    }  
      
    /*
     * 遍历子节点
     */
    public void listNodes(Element node){  
        System.out.println("当前节点的名称：" + node.getName());  
        //首先获取当前节点的所有属性节点  
        List<Attribute> list = node.attributes();  
        //遍历属性节点  
        for(Attribute attribute : list){  
            System.out.println("属性"+attribute.getName() +":" + attribute.getValue());  
        }  
        //如果当前节点内容不为空，则输出  
        if(!(node.getTextTrim().equals(""))){  
             System.out.println( node.getName() + "：" + node.getText());    
        }  
        //同时迭代当前节点下面的所有子节点  
        //使用递归  
        Iterator<Element> iterator = node.elementIterator();  
        while(iterator.hasNext()){  
            Element e = iterator.next();  
            this.listNodes(e);  
        }  
    }
 
	
}  
