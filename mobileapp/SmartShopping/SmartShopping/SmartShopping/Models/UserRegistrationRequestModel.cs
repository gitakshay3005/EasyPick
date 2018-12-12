using Newtonsoft.Json;

namespace SmartShopping.Models
{
    public class UserRegistrationRequestModel
    {
        [JsonProperty("firstName")]
        public string FirstName { get; set; }

        [JsonProperty("lastName")]
        public string LastName { get; set; }

        [JsonProperty("emailId")]
        public string EmailID { get; set; }

        [JsonProperty("password")]
        public string Password { get; set; }        
    }
}