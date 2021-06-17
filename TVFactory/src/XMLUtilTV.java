import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
public class XMLUtilTV
{
    //该方法用于从XML配置文件中提取品牌名称，并返回该品牌名称
    public static String getBrandName()
    {
        try {
            //创建文档文件
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();//获取 DocumentBuilderFactory 的新实例
            DocumentBuilder builder = dFactory.newDocumentBuilder();//使用当前配置的参数创建一个新的 DocumentBuilder 实例
            Document doc;
            doc = builder.parse(new File("configTV.xml"));
            //获取包含品牌名称的文本节点
            NodeList nl = doc.getElementsByTagName("brandName");
            Node classNode = nl.item(0).getFirstChild();//属性返回被选节点的第一个子节点。
            String brandName = classNode.getNodeValue().trim();
            return brandName;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
