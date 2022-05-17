using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WcfServiceLibrary1
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Service1" in both code and config file together.
    public class Service1 : IService1
    {
        public string GetData(int value)
        {
            return string.Format("You entered: {0}", value);
        }

        public string AddNumber(int num1, int num2)
        {
            int a = num1 + num2;
            return string.Format("{0}", a);
        }

        public string DivNumber(int num1, int num2)
        {
            int a = num1 / num2;
            return string.Format("{0}", a);
        }

        public string MultNumber(int num1, int num2)
        {
            int a = num1 * num2;
            return string.Format("{0}", a);
        }

        public string ShowData(int value)
        {
            return string.Format("{0}", value);
        }

        public string SubNumber(int num1, int num2)
        {
            int a = num1 - num2;
            return string.Format("{0}", a);
        }

        public CompositeType GetDataUsingDataContract(CompositeType composite)
        {
            if (composite == null)
            {
                throw new ArgumentNullException("composite");
            }
            if (composite.BoolValue)
            {
                composite.StringValue += "Suffix";
            }
            return composite;
        }

        public void LaunchTheNukes()
        {
            Console.WriteLine("Starting the method LaunchingTheNukes on the server side!");
            OperationContext.Current.GetCallbackChannel<S1Callback>().NumberOfNukesLaunched(1);
        }
    }
}
