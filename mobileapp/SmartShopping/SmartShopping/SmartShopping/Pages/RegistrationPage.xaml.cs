using System;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace SmartShopping.Pages
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class RegistrationPage : ContentPage
	{
		public RegistrationPage ()
		{
			InitializeComponent ();
            //Application.Current.MainPage = RegistrationPage;
        }

        private void ResisterBtn_Clicked(object sender, EventArgs e)
        {

        }
    }
}