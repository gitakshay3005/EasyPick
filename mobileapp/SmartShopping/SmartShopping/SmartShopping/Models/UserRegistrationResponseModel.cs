using Newtonsoft.Json;

namespace SmartShopping.Models
{
    public class UserRegistrationResponseModel
    {
        [JsonProperty("firstName")]
        public string FirstName { get; set; }

        [JsonProperty("lastName")]
        public string LastName { get; set; }

        [JsonProperty("emailId")]
        public string EmailID { get; set; }

        [JsonProperty("id")]
        public string ID { get; set; }

        [JsonProperty("userType")]
        public string UserType { get; set; }

    }
}