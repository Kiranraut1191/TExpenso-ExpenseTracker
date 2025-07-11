import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes'; // adjust path if needed

bootstrapApplication(AppComponent, {
  providers: [
    importProvidersFrom(HttpClientModule),  // ✅ Fixes the HttpClient error
    provideRouter(routes)                   // ✅ if you're using routing
  ]
});
