import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.gui.tree.JMeterTreeModel;
import org.apache.jmeter.gui.tree.JMeterTreeNode;
import org.apache.jmeter.protocol.http.control.RecordingController;
import org.apache.jmeter.protocol.http.proxy.ProxyControl;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.ListedHashTree;

public class Jmeter /*extends ProxyControlGui*/ {
    public static void main(String[] argv) throws Exception {
        // Initialize the configuration variables
        /*String jmeterHome = "D://Junaid//apache-jmeter-3.2";
        JMeterUtils.setJMeterHome(jmeterHome);
        JMeterUtils.loadJMeterProperties(JMeterUtils.getJMeterBinDir()
                + "/jmeter.properties");
        JMeterUtils.initLogging();
        JMeterUtils.initLocale();
        
        
        RecordingController rc=new RecordingController();
        rc.setName("Recording Controller");
        rc.setProperty(TestElement.TEST_CLASS, TestElement.class.getName());
        rc.setProperty(TestElement.GUI_CLASS, LogicControllerGui.class.getName());
        
        // ThreadGroup controller
        LoopController loopController = new LoopController();
        loopController.setEnabled(true);
        loopController.setLoops(1);
        loopController.setProperty(TestElement.TEST_CLASS,
                LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS,
                LoopControlPanel.class.getName());

        // ThreadGroup
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setName("Thread Group");
        threadGroup.setEnabled(true);
        threadGroup.setSamplerController(loopController);
        threadGroup.addTestElement(rc);
        threadGroup.setNumThreads(1);
        threadGroup.setRampUp(1);
        threadGroup.setProperty(TestElement.TEST_CLASS,
                ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS,
                ThreadGroupGui.class.getName());
        
        CookieManager cookieManager = new CookieManager();
        
        cookieManager.setCookiePolicy(CookieManager.DEFAULT_POLICY);
        cookieManager.setImplementation(CookieManager.DEFAULT_IMPLEMENTATION);
        
        // TestPlan
        TestPlan testPlan = new TestPlan();
        testPlan.setName("Test Plan");
        testPlan.setEnabled(true);
        testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.addThreadGroup(threadGroup);
        testPlan.addTestElement(cookieManager);*/
        
        
        
        
        
        
        
        
        // Work Bench start
        
        // Https Test Script Recorder start
        
        // Http Sample
        
        
        
        /*HTTPSampler httpSampler = new HTTPSampler();
        
        httpSampler.setUseKeepAlive(Boolean.TRUE);
        httpSampler.setFollowRedirects(Boolean.TRUE);
        httpSampler.setConcurrentDwn(Boolean.TRUE); // Might be equivalent to Retrieve all embedded resources
        
//        httpSampler.header
        
        JMeterTreeNode tn = new JMeterTreeNode();
        
        tn.setEnabled(Boolean.TRUE);
        tn.set
        
        TreeNodeWrapper treeNodeWrapper = new TreeNodeWrapper(tn, "Use Recording Controller"); // label: use_recording_controller=Use Recording Controller
        
        
        
        
        ProxyControl pc = new ProxyControl();
        
        pc.setGroupingMode(2); // GROUPING_IN_SIMPLE_CONTROLLERS = 4
        pc.setSamplerTypeName("2"); // SAMPLER_TYPE_HTTP_SAMPLER_HC4 = "2"
        pc.setRegexMatch(Boolean.TRUE);
        pc.setPort(8888); // Global Settings -> Port
*/        
        
        // TODO: Https test script recorder
        
        // Workbench code .... done
        
        // Run and save .jmx file ... done
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        


//        LogicControllerGui lc= new LogicControllerGui();


        

        // JavaSampler
        /*JavaSampler javaSampler = new JavaSampler();
        javaSampler.setClassname("my.example.sampler");
        javaSampler.setEnabled(true);
        javaSampler.setProperty(TestElement.TEST_CLASS,
                JavaSampler.class.getName());
        javaSampler.setProperty(TestElement.GUI_CLASS,
                JavaTestSamplerGui.class.getName());*/
        
     // HTTP Sampler
        /*HTTPSampler httpSampler = new HTTPSampler();
//        httpSampler.setDomain("www.google.com");
        httpSampler.setPort(80);
        httpSampler.setPath("/");
        httpSampler.setMethod("GET");

        // Create TestPlan hash tree
        HashTree testPlanHashTree = new HashTree();
        testPlanHashTree.add(testPlan);
        
        testPlan.addThreadGroup(threadGroup);

        // Add ThreadGroup to TestPlan hash tree
        HashTree threadGroupHashTree = new HashTree();
        threadGroupHashTree = testPlanHashTree.add(testPlan);


        // Add Java Sampler to ThreadGroup hash tree
        HashTree javaSamplerHashTree = new HashTree();
        javaSamplerHashTree = threadGroupHashTree.add(rc);




        RecordController rd=new RecordController();
        rd.setName("Record Controller");
        HttpTestSampleGui http=new HttpTestSampleGui();






        WorkBench wb=new WorkBench();
        wb.setProperty(TestElement.TEST_CLASS, WorkBench.class.getName());
        wb.setProperty(TestElement.GUI_CLASS, WorkBenchGui.class.getName());
        wb.setName("WorkBench");
        testPlanHashTree.add(wb);*/


//        javaSamplerHashTree = wb.add(rd);
//        wb.addTestElement();



//        http.putClientProperty(TestElement.TEST_CLASS,
//                JavaSampler.class.getName());
//        http.putClientProperty(TestElement.GUI_CLASS,
//                JavaTestSamplerGui.class.getName());

//        testPlanHashTree.add(http);






        // Save to jmx file
        /*SaveService.saveTree(testPlanHashTree, new FileOutputStream(
                "D://Junaid//k.jmx"));
        System.out.println("completed");*/
        
        
        
        
        
        JMeterUtils.setJMeterHome("D://Junaid//apache-jmeter-3.2"); // Or wherever you put it.
        JMeterUtils.loadJMeterProperties(JMeterUtils.getJMeterBinDir()
                + "/jmeter.properties");
        JMeterUtils.initLocale();
        
        LoopController loopController = new LoopController();
        loopController.setEnabled(true);
        loopController.setLoops(1);
        
        RecordingController rc= new RecordingController();
        rc.setName("Recording Controller");
        
        TestPlan testPlan = new TestPlan();

        ThreadGroup threadGroup1 = new ThreadGroup();
        threadGroup1.setSamplerController(loopController);
        threadGroup1.addTestElement(rc); // Target
        
        ListedHashTree testPlanTree = new ListedHashTree();
        testPlanTree.add(testPlan);
        testPlanTree.add(threadGroup1, testPlan);

        @SuppressWarnings("deprecation") // deliberate use of deprecated ctor
        JMeterTreeModel treeModel = new JMeterTreeModel(new Object());

        JMeterTreeNode root = (JMeterTreeNode) treeModel.getRoot();
        treeModel.addSubTree(testPlanTree, root);
        
        ProxyControl proxy = new ProxyControl();
        proxy.setNonGuiTreeModel(treeModel);
        proxy.setTarget(treeModel.getNodeOf(threadGroup1));
        proxy.setGroupingMode(2); // GROUPING_IN_SIMPLE_CONTROLLERS = 4
        proxy.setSamplerTypeName("2"); // SAMPLER_TYPE_HTTP_SAMPLER_HC4 = "2"
        proxy.setRegexMatch(Boolean.TRUE);
        proxy.setPort(8888); // Global Settings -> Port
        proxy.setCaptureHttpHeaders(Boolean.TRUE);
        proxy.setSamplerFollowRedirects(Boolean.TRUE);

        treeModel.addComponent(proxy, (JMeterTreeNode) root.getChildAt(1));

        proxy.startProxy();
        org.apache.http.HttpHost proxyHost = new org.apache.http.HttpHost("localhost", 8888);
        org.apache.http.impl.conn.DefaultProxyRoutePlanner routePlanner = new org.apache.http.impl.conn.DefaultProxyRoutePlanner(
                proxyHost);
        org.apache.http.impl.client.CloseableHttpClient httpclient = org.apache.http.impl.client.HttpClients.custom()
                .setRoutePlanner(routePlanner).build();

        try {
            httpclient.execute(new org.apache.http.client.methods.HttpGet("http://www.google.com"));
            httpclient.execute(new org.apache.http.client.methods.HttpGet("http://www.stackoverflow.com"));
        } catch (Exception e) {
            //
        }
        proxy.stopProxy();

        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            SaveService.saveTree(treeModel.getTestPlan(), new FileOutputStream(
                    "D://Junaid//k.jmx"));
            out.close();
            System.out.println(out.toString());
        }
        
        
        
        
    }
    
    public Jmeter() {
    	/*super();
    	
    	this.setVisible(Boolean.FALSE); // Donot show gui
    	
    	ProxyControl proxyControl = makeProxyControl();
    	
    	proxyControl.setGroupingMode(2); // GROUPING_IN_SIMPLE_CONTROLLERS = 4
    	proxyControl.setSamplerTypeName("2"); // SAMPLER_TYPE_HTTP_SAMPLER_HC4 = "2"
    	proxyControl.setRegexMatch(Boolean.TRUE);
    	proxyControl.setPort(8888); // Global Settings -> Port
    	proxyControl.setCaptureHttpHeaders(Boolean.TRUE);
    	proxyControl.setSamplerFollowRedirects(Boolean.TRUE);*/
    }
    
    
    
    
    
    
    
    
    
    
}