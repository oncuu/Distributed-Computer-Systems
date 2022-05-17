using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WcfServiceLibrary1
{

    public interface S1Callback
    {
        [OperationContract(IsOneWay = true)]
        void NumberOfNukesLaunched(int i);
    }

    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService1" in both code and config file together.
    [ServiceContract(CallbackContract = typeof(S1Callback))]
    public interface IService1
    {
        [OperationContract]
        string GetData(int value);

        [OperationContract]
        string ShowData(int value);

        [OperationContract]
        string AddNumber(int num1, int num2);

        [OperationContract]
        string SubNumber(int num1, int num2);

        [OperationContract]
        string DivNumber(int num1, int num2);

        [OperationContract]
        string MultNumber(int num1, int num2);

        [OperationContract]
        CompositeType GetDataUsingDataContract(CompositeType composite);

        // TODO: Add your service operations here
        [OperationContract(IsOneWay = true)]
        void LaunchTheNukes();

    }

    // Use a data contract as illustrated in the sample below to add composite types to service operations.
    // You can add XSD files into the project. After building the project, you can directly use the data types defined there, with the namespace "WcfServiceLibrary1.ContractType".
    [DataContract]
    public class CompositeType
    {
        bool boolValue = true;
        string stringValue = "Hello ";
        int intValue = 0;

        [DataMember]
        public bool BoolValue
        {
            get { return boolValue; }
            set { boolValue = value; }
        }

        [DataMember]
        public string StringValue
        {
            get { return stringValue; }
            set { stringValue = value; }
        }

        public int IntValue
        {
            get { return intValue; }
            set { intValue = value; }
        }
    }
}
