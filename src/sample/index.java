/**
 * @author	Marcio Alexandre - marcio.alexandre83@gmail.com
 *
 * This is a free software in which it's shown how you can change XBRL files to Json format.
 * Please, pay attention about jeasyXBRL and Gson copyrights for using them in your projects/systems.
 * It's important to know that jeasyXBRL works with Guava (another library also from google).
 * 
 * @JeasyXBRL	http://xbrlframework.com/wiki/jeasyxbrl/
 * @Guava		https://github.com/google/guava
 * @Gson		https://github.com/google/gson
 */
package sample;
import java.util.ArrayList;
import com.google.gson.Gson;
import jeasyxbrl.JeasyXbrl;
import jeasyxbrl.taxonomy.instance.XbrlInstance;

public class index {
	public static void main(String[] args) throws Throwable {
		// Adding native XBRL instance files: my_dir/file
		ArrayList<String> instanceList = new ArrayList<String>();
		instanceList.add("../xbrlfiles/mwog/mwog-20141031.xml");
		instanceList.add("../xbrlfiles/fb/fb-20130630.xml");
		//(... and so on)
		//Adding native XBRL linkbase file: my_dir/file
		ArrayList<String> labelList = new ArrayList<String>();
		labelList.add("../xbrlfiles/mwog/mwog-20141031_lab.xml");
		labelList.add("../xbrlfiles/fb/fb-20130630_lab.xml");
		//(... and so on)
		
		//loading Financial report to in-memory Java Class
		JeasyXbrl jxbrl = new JeasyXbrl();
		jxbrl.loadingInstancesInCache(instanceList, labelList, null, null, null, null, null, 1);
		ArrayList<XbrlInstance> xbrlList = jxbrl.getXbrlInstanceListByCache();
		//From in-memory Java Class to Json
		Gson gson = new Gson();
		String xjson = gson.toJson(xbrlList);
		System.out.println(xjson);
	}

}
