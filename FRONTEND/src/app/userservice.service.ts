import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
  private userApi = 'http://localhost:8080/api/user';
  private expenseApi = 'http://localhost:8080/api/expense';
  private balanceApi = 'http://localhost:8080/api/balance';

  constructor(private http: HttpClient) {}

  // 🔐 Login user
  loginUser(credentials: any): Observable<any> {
    return this.http.post(`${this.userApi}/login`, credentials);
  }

  // 📝 Register user
  registerUser(user: any): Observable<any> {
    return this.http.post(`${this.userApi}/register`, user);
  }

  // 📋 Get all users
  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.userApi}/all`);
  }

  // 💸 Send money
  sendPenny(data: any): Observable<any> {
    const userId = sessionStorage.getItem('userId');
    return this.http.post(`${this.expenseApi}/penny/send/${userId}`, data);
  }

  // 📤 Receive money
  recivePenny(data: any): Observable<any> {
    const userId = sessionStorage.getItem('userId');
    return this.http.post(`${this.expenseApi}/penny/get/${userId}`, data);
  }

  // 🧾 All transactions
  getAllExpenseById(): Observable<any[]> {
    const userId = sessionStorage.getItem('userId');
    return this.http.get<any[]>(`${this.expenseApi}/getall/${userId}`);
  }

  // 📆 Get transactions by date
  getExpenseByDate(): Observable<any[]> {
    const userId = sessionStorage.getItem('userId');
    return this.http.get<any[]>(`${this.expenseApi}/getdates/${userId}`);
  }

  // 💰 Net balance
  getNetBalanceId(): Observable<any> {
    const userId = sessionStorage.getItem('userId');
    return this.http.get(`${this.balanceApi}/get/${userId}`);
  }

  // 🔍 View user by ID
  getUserById(id: number): Observable<any> {
    return this.http.get<any>(`${this.userApi}/user/${id}`);
  }

  // 👁️ View user (profile or logged-in user)
  viewUser(id: string): Observable<any> {
    return this.http.get(`${this.userApi}/view/${id}`);
  }

  // 🗑️ Delete user by ID
  deleteUser(id: number): Observable<any> {
  return this.http.delete(`${this.userApi}/delete/${id}`);
}

}
