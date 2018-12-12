using Newtonsoft.Json;

namespace SmartShopping.Models
{
    public class LoginRequestModel
    {
        [JsonProperty("emailId")]
        public string EmailID { get; set; }

        [JsonProperty("password")]
        public string Password { get; set; }
    }
}