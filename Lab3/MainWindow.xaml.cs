using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Markup;

// Jacob Knox CST 238 Lab 3 4/22/2023

namespace JacobKLab3
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        Dictionary<String, ResourceDictionary> styleMap = new Dictionary<String, ResourceDictionary>();
        ResourceDictionary defaultStyle = new ResourceDictionary();

        public MainWindow()
        {
            InitializeComponent();
            // load the default style
            defaultStyle = LoadResourceDictionary("DefaultStyle.xaml");
            SetStyle(defaultStyle);

            // load the other styles
            styleMap.Add("style1", LoadResourceDictionary("Style1.xaml"));
            styleMap.Add("style2", LoadResourceDictionary("Style2.xaml"));
            styleMap.Add("style3", LoadResourceDictionary("Style3.xaml"));
            styleMap.Add("style4", LoadResourceDictionary("Style4.xaml"));
        }

        ResourceDictionary LoadResourceDictionary(String name) {
            String basePath = "../../../";
            // Read in ResourceDictionary File
            return (ResourceDictionary)XamlReader.Load(System.Xml.XmlReader.Create(basePath + name));
        }

        void SetStyle(ResourceDictionary style) {
            // clear previous styles
            Resources.MergedDictionaries.Clear();
            // add the defualt style first to to overriden by the other styles
            Resources.MergedDictionaries.Add(defaultStyle);
            // Add in newly loaded Resource Dictionary
            Resources.MergedDictionaries.Add(style);

        }

        private void OnStyleButtonClick(object sender, RoutedEventArgs e)
        { 
            Button buttonSender = (Button)sender;
            // make sure we registered this name as a style
            if (!styleMap.ContainsKey(buttonSender.Name)) {
                return;
            }
            // set the new style
            SetStyle(styleMap[buttonSender.Name]);
        }
    }
}
