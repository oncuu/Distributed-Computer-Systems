using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Description;
using System.Text;
using System.Threading.Tasks;
using WcfServiceLibrary1;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            Uri adress = new Uri("http://localhost:9999/base");
            ServiceHost host = new ServiceHost(typeof(Service1), adress);
            WSDualHttpBinding binding = new WSDualHttpBinding();

            ServiceEndpoint end_point = host.AddServiceEndpoint(typeof(IService1), binding, "service1endpoint");
            ServiceMetadataBehavior behavior = new ServiceMetadataBehavior();
            behavior.HttpGetEnabled = true;
            host.Description.Behaviors.Add(behavior);

            try
            {
                host.Open();
                Console.ReadLine();
                host.Close();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                host.Abort();
            }
        }
    }
}
