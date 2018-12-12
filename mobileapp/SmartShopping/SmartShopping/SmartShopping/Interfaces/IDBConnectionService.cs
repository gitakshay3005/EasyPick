using SQLite;

namespace SmartShopping.Interfaces
{
    public interface IDBConnectionService
    {
        SQLiteConnection GetConnection(string filename);        
    }
}
