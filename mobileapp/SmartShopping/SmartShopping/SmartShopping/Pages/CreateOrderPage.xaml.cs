using SmartShopping.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Essentials;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace SmartShopping.Pages
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class CreateOrderPage : ContentPage
	{
		public CreateOrderPage ()
		{
			InitializeComponent ();
		}

        public CreateOrderPage(string item)
        {
            InitializeComponent();
            productListView.ItemsSource = new List<Product>
            {
                new Product(){ ID = "1", Name = item , Quantity = " 1 "
                }
            };
        }

        private void productListView_ItemTapped(object sender, ItemTappedEventArgs e)
        {

        }

        private async void GetLocationCordinate()
        {
            try
            {
                var location = await Geolocation.GetLastKnownLocationAsync();

                if (location != null)
                {
                    Console.WriteLine($"Latitude: {location.Latitude}, Longitude: {location.Longitude}, Altitude: {location.Altitude}");
                }
            }
            catch (FeatureNotSupportedException fnsEx)
            {
                // Handle not supported on device exception
            }
            catch (PermissionException pEx)
            {
                // Handle permission exception
            }
            catch (Exception ex)
            {
                // Unable to get location
            }
        }
    }
}