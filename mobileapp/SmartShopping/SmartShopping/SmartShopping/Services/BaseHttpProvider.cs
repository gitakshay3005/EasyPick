
using Newtonsoft.Json;
using System;
using System.Diagnostics;
using System.Net.Http;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace OSAMobileAlertsApp.Services
{
    public class BaseHttpProvider
    {
        #region Data Members


        #endregion

        public BaseHttpProvider()
        {

        }


        /// <summary>
        /// Post Data Async
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <param name="requestUri"></param>
        /// <param name="body"></param>
        /// <param name="ivKey"></param>
        /// <returns></returns>
        public async Task<Object> PostDataAsync<T>(Uri requestUri, string body = "", string ivKey = "")
        {

            try
            {
                //if (_networkConnection.IsNetworkAvailable())
                //{
                using (HttpClient client = CreateHttpClient(ivKey))
                {
                    using (HttpContent content = CreateHttpContent(body))
                    {
                        using (HttpResponseMessage response = await client.PostAsync(requestUri, content))
                        {
                            return await GetResponseBody<T>(response);
                        }
                    }
                }
                //}
                //else
                //{

                //    Device.BeginInvokeOnMainThread(async () =>
                //    {
                //        await _dialogService.DisplayAlertAsync(AppResources.NoNetworkTitle, AppResources.NoNetworkMessage, AppResources.OkTxt);
                //    });

                //}
            }
            catch (Exception ex)
            {
                //await _dialogService.DisplayAlertAsync(AppResources.AlertTitleTxt, AppResources.APIErrorMsg, AppResources.OkTxt);

                Debug.WriteLine(ex.ToString());
            }

            return null;
        }


        public Task<object> PutDataAsync<T>(Uri requestUri, string jsonInput)
        {
            throw new NotImplementedException();
        }

        public Task<object> DeleteDataAsync<T>(Uri requestUri)
        {
            throw new NotImplementedException();
        }

        public Task<object> GetRequestAsync<T>(Uri requestUri)
        {
            throw new NotImplementedException();
        }

        #region Helper Methods

        public HttpClient CreateHttpClient(string ivKey, int timeOut = 1)
        {

            HttpClient httpClient = new HttpClient()
            {
                Timeout = TimeSpan.FromMinutes(timeOut)
            };



            //Required once logged in
            //if (!string.IsNullOrEmpty(Settings.AccessToken))
            //{
            //    httpClient.DefaultRequestHeaders.Add(Constant.TOKEN_ID, Settings.AccessToken);

            //    //Required in case of fetching Product Data
            //    httpClient.DefaultRequestHeaders.Add(Constant.ACCEPT_LANGUAGE_HEADER, Constant.ACCEPT_LANGUAGE_HEADER_VALUE);
            //}

            return httpClient;

        }

        private HttpContent CreateHttpContent(string content)
        {
            HttpContent httpContent = new StringContent(content, System.Text.Encoding.UTF8, "application/json");
            return httpContent;
        }



        public async Task<object> GetResponseBody<T>(HttpResponseMessage response)
        {
            string value = await response.Content?.ReadAsStringAsync();

            if (!string.IsNullOrWhiteSpace(value))
            {
                if (!response.IsSuccessStatusCode)
                {
                    if (response.StatusCode == System.Net.HttpStatusCode.InternalServerError)
                    {
                        return JsonConvert.DeserializeObject<SmartShopping.Models.ExceptionMessageResponseModel>(value);
                    }
                }
                else
                {
                    return JsonConvert.DeserializeObject<T>(value);
                }
            }
            return response;
        }
        #endregion


    }
}
