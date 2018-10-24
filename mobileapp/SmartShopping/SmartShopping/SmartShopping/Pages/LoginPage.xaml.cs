using System;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace SmartShopping.Pages
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class LoginPage : ContentPage
	{
		public LoginPage ()
		{
			InitializeComponent ();
		}

        private void SigninBtn_Clicked(object sender, EventArgs e)
        {
            //Navigation.PushAsync(new HomePage());
            Application.Current.MainPage = new NavigationPage(new HomePage());
        }

        private void RegisterBtn_Clicked(object sender, EventArgs e)
        {
            //Navigation.PushAsync(new RegistrationPage());
            Application.Current.MainPage = new NavigationPage(new RegistrationPage());
        }

        private void UNameEntry_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (string.IsNullOrWhiteSpace(UNameEntry.Text))
                UNameLbl.IsVisible = false;
            else
                UNameLbl.IsVisible = true;
        }

        private void PasswordEntry_TextChanged(object sender, TextChangedEventArgs e)
        {
            if (string.IsNullOrWhiteSpace(PasswordEntry.Text))
                PasswordLbl.IsVisible = false;
            else
                PasswordLbl.IsVisible = true;
        }

    
    }
}