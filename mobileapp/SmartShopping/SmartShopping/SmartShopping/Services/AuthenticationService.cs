using Newtonsoft.Json;
using OSAMobileAlertsApp.Services;
using SmartShopping.Models;
using System;
using System.Threading.Tasks;

namespace SmartShopping.Services
{
    public class AuthenticationService : BaseHttpProvider
    {
        //Post call for Login functionality
        public async Task<object> PostUserRegistrationDataAsync(UserRegistrationRequestModel loginRequest)
        {
            string requestUri =string.Empty; //= $"{Constant.BASE_URI}{Constant.LOGIN_API}";
            string jsonInput = JsonConvert.SerializeObject(loginRequest);
            return await PostDataAsync<UserRegistrationResponseModel>(new Uri(requestUri), jsonInput);
        }


        //Post call for Login functionality
        public async Task<object> PostLoginDataAsync(LoginRequestModel loginRequest)
        {
            string requestUri =string.Empty;//= $"{Constant.BASE_URI}{Constant.LOGIN_API}";
            string jsonInput = JsonConvert.SerializeObject(loginRequest);
            return await PostDataAsync<LoginResponseModel>(new Uri(requestUri), jsonInput);
        }
    }
}
